/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Registro;
import model.dao.RegistroDaoJpa;
import model.dao.DaoFactory;
import model.dao.InterfaceDao;


public class RegistroSrv extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {

            String acao = request.getParameter("acao");
            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String produto = request.getParameter("produto");
            String endereco = request.getParameter("endereco");
            String telefone= request.getParameter("telefone");

            InterfaceDao dao = DaoFactory.novoRegistroDao();
            Registro c = null;
            RequestDispatcher rd = null;

            switch (acao) {

                case "inclusao":
                    c = new Registro(nome, produto, endereco, telefone);
                    try {
                        dao.incluir(c);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagem());
                    rd.forward(request, response);

                    break;

                case "pre-edicao":
                    c = (Registro) dao.pesquisarporId(Integer.parseInt(id));
                    rd = request.getRequestDispatcher("Formulario.jsp?acao=edicao"
                            + "&id=" + c.getId()
                            + "&nome=" + c.getNome()
                            + "&produto=" + c.getProduto()
                            + "&endereco=" + c.getEndereco()
                            + "&telefone=" + c.getTelefone());
                    rd.forward(request, response);
                    break;

                case "edicao":
                    c = new Registro(nome, produto, endereco, telefone);
                    c.setId(Integer.parseInt(id));
                    try {
                        dao.editar(c);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagem());
                    rd.forward(request, response);
                    break;

                case "exclusao":
                    try {
                        c = new Registro();
                        c.setId(Integer.parseInt(id));
                        dao.excluir(c);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagem());
                    rd.forward(request, response);
                    break;
                    
                case "pesquisar" :
                    try {
                        c = new Registro();
                        //c.setId(Integer.parseUnsignedInt(nome));
                        //c.getNome();
                        dao.pesquisar("nome");
                        System.out.println(nome);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("nome");
                    rd.forward(request, response);
                    break;
                    

                case "listagem":
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagem());
                    rd.forward(request, response);
                    
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(RegistroSrv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String listagem() {
        InterfaceDao dao = new RegistroDaoJpa();
        List<Registro> lista = null;

        try {
            lista = dao.listar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        String listaHTML = " ";
        for (Registro registro : lista) {
            listaHTML = listaHTML
                    + "<tr>"
                    + "<td>" + registro.getNome() + "</td>"
                    + "<td>" + registro.getProduto() + "</td>"
                    + "<td>" + registro.getEndereco() + "</td>"
                    + "<td>" + registro.getTelefone() + "</td>"
                    
                    + "<td><form action=RegistroSrv?acao=pre-edicao method='POST'>"
                    + "<input type='hidden' name='id' value="
                    + registro.getId() + "><input type='submit' value=editar>"
                    + "</form></td>"
                    + "<form action=RegistroSrv?acao=exclusao method='POST'>"
                    + "<td><input type='hidden' name='id' value="
                    + registro.getId() + "><input type='submit' value=excluir></td>"
                    + "</form>"
                    
                    + "</tr>";
        }
        return listaHTML;   

    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
