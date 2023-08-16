package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DTO.Myuser;
import DTO.Task;
import antlr.collections.List;

public class Userdao {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	

	public void save(Myuser myuser) {
		entityTransaction.begin();
		entityManager.persist(myuser);
		entityTransaction.commit();	
	}
	public Myuser findByEmail(String email) {
		java.util.List<Myuser>list=entityManager.createQuery("select x from Myuser x where email=?1")
				.setParameter(1, email)
				.getResultList();
		if(list.isEmpty()){
			return null;
		}else {
			return list.get(0);
		}
	}
		public void save(Task task){
			entityTransaction.begin();
			entityManager.persist(task);
			entityTransaction.commit();
		}
		public java.util.List<Task> fetchAllTask(){
			return entityManager.createQuery("select x from Task x").getResultList();
			
		}
		public void update(Myuser myuser) {
			entityTransaction.begin();
			entityManager.merge(myuser);
			entityTransaction.commit();
			
		}
		public Task fetchTask(int id) {
			return entityManager.find(Task.class,id);
		}
		
		public void update(Task task) {
			entityTransaction.begin();
			entityManager.persist(task);
			entityTransaction.commit();
		}
		public void remove(Task task) {
			entityTransaction.begin();
			entityManager.persist(task);
			entityTransaction.commit();
		}
	
}
