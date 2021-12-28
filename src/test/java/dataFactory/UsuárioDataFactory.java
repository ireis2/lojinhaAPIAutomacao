package dataFactory;

import pojo.UsuárioPojo;

public class UsuárioDataFactory {
    public static UsuárioPojo criarUsuarioAdministrador(){

        UsuárioPojo usuario = new UsuárioPojo();
        usuario.setUsuarioLogin("admin");
        usuario.setUsuarioSenha("admin");

        return usuario;
    }
}
