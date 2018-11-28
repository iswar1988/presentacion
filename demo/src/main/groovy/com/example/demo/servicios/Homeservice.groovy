package com.example.demo.servicios

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class Homeservice {

    @Autowired
    final JdbcTemplate conexion;

    def GetCliente()
    {
        return conexion.queryForList("select * from t_clientes");
    }

    def GuardarCliente()
    {
        conexion.execute("insert into t_clientes(f_nombre,f_apellido) values ('Jose','Fernando')")
        return "Listo"
    }

    def GuardarCliente(String nombre,String apellido)
    {
        conexion.execute("insert into t_clientes(f_nombre,f_apellido) values ('$nombre','$apellido')")
        return "Listo"
    }

}
