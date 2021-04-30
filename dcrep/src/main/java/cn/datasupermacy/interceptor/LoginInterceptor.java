package cn.datasupermacy.interceptor;

import cn.datasupermacy.Exceptions.LoginExcepinon;
import cn.datasupermacy.service.UserService;
import cn.datasupermacy.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        // 从 http 请求头中取出 token
        String token = request.getHeader("Authorization");
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        if (token!=null){
            String uloginName = JwtUtil.getuloginnameByToken(request);

            String sourceToken = redisTemplate.opsForValue().get(uloginName);

            if (StringUtils.isNotBlank(sourceToken)){
                if (Objects.equals(token,sourceToken)){
                    return true;
                }
            }
//            // 这边拿到的 登录名去数据库查询获得密码
//            boolean result = JwtUtil.verify(token,uloginName,userService.findByUlogname(uloginName).getUpwd());
//            if (result){
//                //通过拦截器
//                return true;
//            }

        }
        try {
            throw new LoginExcepinon(401,"token失效/未登录");
        } catch (LoginExcepinon loginExcepinon) {
            System.out.println(loginExcepinon.getMessage());
            loginExcepinon.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        //别动，401是token失效标志前端弹出重新登录
        response.setStatus(401);

        return false;//如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
        //如果设置为true时，请求将会继续执行后面的操作
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{

    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{

    }
}
