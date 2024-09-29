package com.ciberfarma.app;

import java.util.List;

import com.ciberfarma.model.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;



public class Demo01_listado_combinado {

	public static void main(String[] args) {
		
		
		EntityManagerFactory conexion = Persistence.createEntityManagerFactory("jpa_mysql"); 
		EntityManager em = conexion.createEntityManager();
		
		//sql = "select u.cod_usua, concat(nom_usua, ape_usua), u.idtipo, t.descripcion from tb_usuarios u join tb_tipos t on u.idtipo = t.idtipo"
		//jpql = "select u from Usuario u"
		
		//List<Usuario> lstUsuarios = em.createNativeQuery(sql, Usuario.class).getResultList();
		//("select * from tb_usuarios",
		// Usuario.class).getResultList();
	
		
		List<Usuario> lstUsuarios = em.createQuery("select u from Usuario u").getResultList();
		for (Usuario u: lstUsuarios) {
			System.out.println("Nombre...:" + u.getNom_usua() + "" + u.getApe_usua());
			System.out.println("Email....:" + u.getUsr_usua());
			System.out.println("Clave....:" + u.getCla_usua());
			System.out.println("Fch nac..:" + u.getFna_usua());
			System.out.println("Tipo.....:" + u.getIdtipo());
			System.out.println("Tipo.....:" + u.getObjTipo().getDescripcion());
			System.out.println("Estado...:" + u.getEst_usua());
			System.out.println("--------------------------------");
		}
		
		
		
	}
	
}
