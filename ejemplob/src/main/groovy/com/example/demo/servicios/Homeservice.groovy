package com.example.demo.servicios

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class Homeservice {

    @Autowired
    JdbcTemplate conexion;

    def  GetClientes()
    {

        return conexion.queryForList("select * from  t_clientes");
    }

    def GuardarClientes()
    {
        conexion.execute("insert into t_clientes(f_nombre,f_apellido) values('iswar','bencosme')");
        return "Listo";
    }

    def GuardarConValores(String nombre,String apellido)
    {

        conexion.execute("insert into t_clientes(f_nombre,f_apellido) values('$nombre','$apellido')");
        return "Listo";

    }



}
