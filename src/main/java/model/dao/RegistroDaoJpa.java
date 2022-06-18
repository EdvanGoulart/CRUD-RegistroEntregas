/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Registro;


public class RegistroDaoJpa implements InterfaceDao<Registro> {

    @Override
    public void incluir(Registro entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void editar(Registro entidade) throws Exception {
         EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entidade);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void excluir(Registro entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            Registro c1 = em.find(Registro.class, entidade.getId());
            em.remove(c1);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Registro pesquisarporId(int id) throws Exception {
        Registro c = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            c = em.find(Registro.class, id);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        
        return c;
    }
    
    @Override
    public Registro pesquisar(String nome) throws Exception {
        Registro c = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            c = em.find(Registro.class, nome);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return c;
    }

    @Override
    public List<Registro> listar() throws Exception {
       List<Registro> lista = null;
       EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            lista = em.createQuery("FROM Registro c").getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return lista;
    }

    /*public List<Album> listar(String param) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        PreparedStatement ps = null;
        if (param == "") {
            ps = em.prepareStatement("SELECT * FROM CD");
        } else {
            ps = em.find(Album, ps)prepareStatement("SELECT * FROM CD WHERE nome like '%" + param + "%'");
        }
        
        ResultSet rs = ps.executeQuery();
        List<Album> lista = new ArrayList();
        while (rs.next()) {
            Album a = new Album();
            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
            a.setAnoLancamento(rs.getString("anoLancamento"));
            a.setArtista(rs.getString("artista"));
            lista.add(a);
        }
        return lista;
    }*/

}
