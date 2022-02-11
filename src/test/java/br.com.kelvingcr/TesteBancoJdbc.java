package br.com.kelvingcr;

import br.com.kelvingcr.dao.UserPosDAO;
import br.com.kelvingcr.model.Userposjava;
import org.junit.Test;

public class TesteBancoJdbc {

    @Test
    public void initBanco(){
        UserPosDAO userPosDAO = new UserPosDAO();
        Userposjava user = new Userposjava(2L, "leandro", "leandro@gmail.com");
        userPosDAO.salvar(user);
    }

    @Test
    public void initListar(){
        UserPosDAO userPosDAO = new UserPosDAO();
        for(Userposjava users : userPosDAO.listar()){
            System.out.println(users.toString());
        }
    }

    @Test
    public void buscarPorId(){
        UserPosDAO userPosDAO = new UserPosDAO();
        System.out.println(userPosDAO.buscar(2L).toString());
    }

    @Test
    public void initAtualizar(){
        UserPosDAO userPosDAO = new UserPosDAO();
        Userposjava obj = userPosDAO.buscar(1L);
        obj.setNome("Elias");

        userPosDAO.atualizarUsuario(obj);
    }

}
