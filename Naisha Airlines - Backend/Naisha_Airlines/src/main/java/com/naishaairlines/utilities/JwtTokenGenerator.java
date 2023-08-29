package com.naishaairlines.utilities;




import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class JwtTokenGenerator extends OncePerRequestFilter {
	
//	private final SecretKey secretKey = Keys.hmacShaKeyFor(SecurityDetails.JWT_KEY.getBytes());
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            String jwt = generateToken(authentication);
//            response.addHeader(SecurityDetails.JWT_HEADER, "Bearer " + jwt);
//        }
//
//        filterChain.doFilter(request, response);
//    }
//    
//    public String generateToken(Authentication authentication) {
//        User user = (User) authentication.getPrincipal();
//        String authorities = getValue(user.getAuthorities());
//
//        return Jwts.builder()
//        		.setIssuer("Naisha Airlines")
//                .setSubject("JWT_TOKEN")
//                .claim("username", user.getUsername())
//                .claim("authorities", authorities)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(new Date().getTime() + SecurityDetails.EXPIRATION_TIME))
//                .signWith(secretKey)
//                .compact();
//    }


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication() ;
		System.out.println();
		if(authentication != null) {
			SecretKey key = Keys.hmacShaKeyFor(SecurityDetails.JWT_KEY.getBytes()) ;
			String jwt = Jwts.builder()
					.setIssuer("NaishaAirlines")
					.setSubject("JWT_Token")
					.claim("username", authentication.getName()) 
					.claim("authorities", getValue(authentication.getAuthorities())) 
					.setIssuedAt(new Date())
					.setExpiration(new Date( new Date().getTime()+10800000))
					.signWith(key).compact() ;
			response.setHeader(SecurityDetails.JWT_HEADER, jwt);
		}
		else {
			System.out.println("Could Not generate Token");
		}
		
		filterChain.doFilter(request, response);
	}
	
	
	public String getValue(Collection<? extends GrantedAuthority> collection) {
		Set<String> set = new HashSet<>() ;
		for(GrantedAuthority autho : collection) {
			set.add(autho.getAuthority()) ;
		}
		return String.join(",", set) ;
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
	    String servletPath = request.getServletPath();
	    return !(
	        servletPath.equals("/passengers/login") ||
	        servletPath.equals("/admins/login") 
	        
	    );
	}
	
	
}
