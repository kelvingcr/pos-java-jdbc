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
}
