package Controler;

import DAO.CamisetaDAO;
import Model.Camiseta;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "CamisetaControle", urlPatterns = {
    "/cadastrarCamiseta",
    "/listarCamisetas",
    "/desativarCamiseta",
    "/iniciarEdicaoCamiseta",
    "/editarCamiseta"
})

public class ControllerCamiseta extends HttpServlet{
    
    private File diretorio;
    
    
    	@Override
	public void init(ServletConfig config) throws ServletException {
                super.init(config);
		String path = config.getInitParameter("diretorio");
		diretorio = new File(path);
		diretorio.mkdirs();
	}
        
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			out.println("<h1>Voce não enviou um arquivo!</h1>");
			return;
		}
		
		for (String elemento : request.getParameterMap().keySet()) {
			System.out.println(elemento);
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(diretorio);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items ) {
			    if (!item.isFormField()) {
			        processUploadedFile(item);
			    } else {
			    	//para inputs que nao sao 'file', isFormField() é verdadeiro 
			    	String nomeDoCampo = item.getFieldName();
				String valorDoCampo = item.getString();
				System.out.println(nomeDoCampo + ": " + valorDoCampo);
			    }
			}
			
			out.println("<h1>Arquivo gravado!</h1>");
			
		} catch (Exception e) {
			out.println("<h1>Erro ao escrever no arquivo!</h1>");
			return;
		}
	}
        
	private void processUploadedFile(FileItem item) throws Exception {
		String fileName = item.getName();
		File uploadedFile = new File(diretorio, fileName);
	    item.write(uploadedFile);
	}
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String uri = request.getRequestURI();

            if (uri.equals(request.getContextPath() + "/desativarCamiseta")) {
                desativar(request, response);
            } else if (uri.equals(request.getContextPath() + "/listarCamisetas")) {
                listarTodos(request, response);
            } else if (uri.equals(request.getContextPath() + "/iniciarEdicaoCamiseta")) {
                iniciarEdicao(request, response);
            } 
            
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("Erro.jsp");
            }
    }
   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String uri = request.getRequestURI();

            if (uri.equals(request.getContextPath() + "/cadastrarCamiseta")) {
                cadastrar(request, response);
            } else if (uri.equals(request.getContextPath() + "/editarCamiseta")) {
                confirmarEdicao(request, response);
            } else {
                response.sendRedirect("404.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("../Erro.jsp");
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
        Camiseta camiseta = new Camiseta();
        camiseta.setNome(request.getParameter("txtNome"));
        camiseta.setDescricao(request.getParameter("txtDescricao"));
        camiseta.setSexo(request.getParameter("txtSexo"));
        camiseta.setTamanho(request.getParameter("txtTamanho"));
        camiseta.setImagem(request.getParameter("txtImagem"));
        camiseta.setSituacao(request.getParameter("optSituacao"));
        camiseta.setQuantidade(Integer.valueOf(request.getParameter("txtQuantidade")));
        camiseta.setPreco(Double.parseDouble(request.getParameter("txtPreco")));
        

        CamisetaDAO dao = new CamisetaDAO();
        dao.cadastrar(camiseta);
        
       response.sendRedirect("listarCamisetas");

        
    }

    private void iniciarEdicao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Camiseta camiseta = new Camiseta();
        CamisetaDAO dao = new CamisetaDAO();
        camiseta.setId(Integer.valueOf(request.getParameter("id")));

        dao.consultarporId(camiseta);

        request.setAttribute("camiseta", camiseta);
        request.getRequestDispatcher("admin/EdCamiseta.jsp").forward(request, response);
    }

    private void confirmarEdicao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Camiseta camiseta = new Camiseta();
        CamisetaDAO dao = new CamisetaDAO();
        camiseta.setId(Integer.valueOf(request.getParameter("id")));
        camiseta.setNome(request.getParameter("nome"));
        camiseta.setDescricao(request.getParameter("descricao"));
        camiseta.setSexo(request.getParameter("sexo"));
        camiseta.setTamanho(request.getParameter("tamanho"));
        camiseta.setImagem(request.getParameter("imagem"));
        camiseta.setSituacao(request.getParameter("situacao"));
        camiseta.setQuantidade(Integer.valueOf(request.getParameter("quantidade")));
        camiseta.setPreco(Double.valueOf(request.getParameter("preco")));

        dao.Editar(camiseta);
        response.sendRedirect("listarCamisetas");
    }

    private void desativar(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Camiseta camiseta = new Camiseta();
        CamisetaDAO dao = new CamisetaDAO();
        camiseta.setId(Integer.valueOf(request.getParameter("id")));

        dao.consultarporId(camiseta);
        dao.Desativar(camiseta);
        
        response.sendRedirect("listarCamisetas");
    }

    private void listarTodos(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        CamisetaDAO dao = new CamisetaDAO();

        List<Camiseta> todasCamisetas = dao.consultarTodos();
        request.setAttribute("todasCamisetas", todasCamisetas);
        
        request.getRequestDispatcher("admin/listarCamiseta.jsp").forward(request, response);

    }
    
} 

