package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mb.HashMB;
import mb.LoginMB;

public class LoginFilter implements Filter {

	private boolean sessaoVazia;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String url = req.getRequestURL().toString();
		sessaoVazia = false;
		LoginMB loginMB = (LoginMB) (req.getSession().getAttribute("loginMB"));
		if (loginMB != null) {
			boolean isLog = loginMB.isLoggedIn();
			System.out.println(isLog);
			
			
		}
		
		HashMB hashMb = (HashMB) (req.getSession().getAttribute("hashMB"));
		if (hashMb == null) {
			hashMb = new HashMB();

		}
		
		if (loginMB == null) {
			sessaoVazia = true;
		}

		System.out.println(loginMB);
	
		if (url.contains("/restrito/") && (sessaoVazia == true || (!loginMB.isLoggedIn() || loginMB == null))) {
			resp.sendRedirect(req.getServletContext().getContextPath() + "/index.jsf?faces-redirect=true");
		} else {
			chain.doFilter(request, response);
		}

		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public boolean isSessaoVazia() {
		return sessaoVazia;
	}

	public boolean setSessaoVazia(boolean sessaoVazia) {
		this.sessaoVazia = sessaoVazia;
		return sessaoVazia;
	}

}
