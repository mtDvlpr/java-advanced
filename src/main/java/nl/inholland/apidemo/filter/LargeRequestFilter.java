package nl.inholland.apidemo.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(1)
public class LargeRequestFilter implements Filter {

  @Value("${movies.security.request.size.max}")
  private int maxSize;


  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("Starting filter");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    int size = request.getContentLength();
    if (size > maxSize) {
      System.out.printf("Request with size %d is bigger than %d%n", size, maxSize);
      throw new ServletException("Request was too large");
    } else {
      chain.doFilter(request, response);
    }
  }

  @Override
  public void destroy() {
    System.out.println("Stopping application");
  }
}
