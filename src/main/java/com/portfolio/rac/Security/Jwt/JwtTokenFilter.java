
package com.portfolio.rac.Security.Jwt;

import com.portfolio.rac.Security.Service.UserDetailServiceImp;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;


public class JwtTokenFilter extends OncePerRequestFilter {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvaider.class);

  @Autowired
  JwtProvaider jwtProvaider;
  @Autowired
  UserDetailServiceImp userDetailsServiceImpl;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String token = getToken(request);
            if(token != null && jwtProvaider.validateToken(token)){
                String nombreUsuario = jwtProvaider.getNombreUsuarioFromToken(token);
                UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            }
        } catch (Exception e) {
         logger.error("Fallo el metodo doFilterInternal");
        }
        filterChain.doFilter(request, response);           
        
    }
    private String getToken(HttpServletRequest request){
      String header = request.getHeader("Authorization");
      if(header != null && header.startsWith("Bearer"))
      return header.replace("Bearer", "");
      
     return null;
    }
  
  
}
