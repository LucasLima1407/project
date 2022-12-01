package br.com.java.mapper.custom;

import org.springframework.stereotype.Service;

import br.com.java.data.vo.v2.AdminVOV2;
import br.com.java.modal.Admin;
import jakarta.persistence.Table;

@Table
public class AdmMapper {

	public AdminVOV2 convertEntityToVo(Admin admin) {
		AdminVOV2 vo = new AdminVOV2();
		vo.setKey(admin.getId());
		vo.setNome(admin.getNome());
		vo.setLogin(admin.getLogin());
		vo.setSenha(admin.getSenha());
		return vo;
	}
	public Admin convertVoTOEntity(AdminVOV2 admin) {
		Admin entity = new Admin();
		entity.setId(admin.getKey());
		entity.setNome(admin.getNome());
		entity.setLogin(admin.getLogin());
		entity.setSenha(admin.getSenha());

		return entity;
	}
}
