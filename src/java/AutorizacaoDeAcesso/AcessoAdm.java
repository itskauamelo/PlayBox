package AutorizacaoDeAcesso;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Usuario;
import Model.EnumPerfilAcesso;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kauã Morateli
 */

//Filtro que controla o acesso a área restrita do sistema


public class AcessoAdm implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException 
    {
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
    
        //recupera a sessao
        HttpSession sessaoUsuario = ((HttpServletRequest)request) .getSession();
        Usuario usuario = (Usuario) sessaoUsuario.getAttribute("usuarioAutenticado");
        
        if(usuario!=null && usuario.getPerfil().equals(EnumPerfilAcesso.ADMINISTRADOR)){
            chain.doFilter(request, response);
        } else
        {
            ((HttpServletResponse)response).sendRedirect("../acessoNegado.jsp");
           
        }
        
}

@Override
public void destroy() {

}

}
    
