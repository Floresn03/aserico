package com.ab.springboot.backend.AppCursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ab.springboot.backend.AppCursos.dao.CursoDao;
import com.ab.springboot.backend.AppCursos.model.Curso;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoDao cursoDao;
	@Override
	@Transactional(readOnly = false)
	public Curso save(Curso curso) {
		return cursoDao.save(curso);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer id_curso) {
		cursoDao.deleteById(id_curso);
	}

	@Override
	@Transactional(readOnly = true)
	public Curso findById(Integer id_curso) {
		return cursoDao.findById(id_curso).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Curso> findAll() {
		return (List<Curso>) cursoDao.findAll();
	}

}
