package com.example.demo.controladores

import com.example.demo.servicios.Homeservice
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletRequest


@RestController
class Home {

    @Autowired
    Homeservice homeservice;

    @RequestMapping("/inicio")
    def Inicio()
    {

        return "pruebahtml";
    }

    @RequestMapping(value = "/consultar",method = RequestMethod.GET)
    def ConsultarClientes()
    {

        return homeservice.GetClientes();

    }


    @RequestMapping("/guardar")
    def GuardarClientes()
    {
        return homeservice.GuardarClientes();

    }

    @RequestMapping(value = "/guardarconvalores",method = RequestMethod.POST)
    def GuardarConValores(HttpServletRequest request)
    {
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");

        return homeservice.GuardarConValores(nombre,apellido);

    }



}
