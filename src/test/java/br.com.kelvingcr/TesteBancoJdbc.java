package br.com.kelvingcr;

import br.com.kelvingcr.dao.TelefoneDAO;
import br.com.kelvingcr.dao.UserPosDAO;
import br.com.kelvingcr.model.BeanUserFone;
import br.com.kelvingcr.model.Telefone;
import br.com.kelvingcr.model.Userposjava;
import org.junit.Test;

public class TesteBancoJdbc {

    @Test
    public void initBanco(){
        UserPosDAO userPosDAO = new UserPosDAO();
        Userposjava user = new Userposjava(null, "caroline", "caroline@gmail.com");
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

    @Test
    public void initDeletar() {
        try {
            UserPosDAO userPosDAO = new UserPosDAO();
            userPosDAO.deletar(4L);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void initBuscarTelefonePorUsuario(){
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        System.out.println(telefoneDAO.buscarTelefoneDeUsuario(2L).toString());
    }

    @Test
    public void initSalvarTelefone(){
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        Telefone telefone = new Telefone();

        telefone.setNumero("9819118");
        telefone.setTipo("fixo");
        telefone.setUsuario_id(2l);

        telefoneDAO.adicionarTelefone(telefone);
    }

    @Test
    public void initlistarUserFone(){
        UserPosDAO userPosDAO = new UserPosDAO();

        for(BeanUserFone beanUserFone : userPosDAO.listaUserFone(1L)){
            System.out.println(beanUserFone);
        }
    }
}
