package com.example.demo.controladores

import com.example.demo.servicios.Homeservice
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletRequest

@RestController
class Home {

    @Autowired
    Homeservice homeservice;

    @RequestMapping("/consultar")
    def Inicio()
    {
        return homeservice.GetCliente();
    }

    @RequestMapping(value = "/guardar",method = RequestMethod.POST)
    def Guardar()
    {
        return homeservice.GuardarCliente();
    }

    @RequestMapping(value = "/insertar",method = RequestMethod.POST)
    def Insertar(HttpServletRequest request)
    {
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        return homeservice.GuardarCliente(nombre,apellido);
    }



}
