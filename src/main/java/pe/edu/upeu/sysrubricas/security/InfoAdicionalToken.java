package pe.edu.upeu.sysrubricas.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import pe.edu.upeu.sysrubricas.dao.AccesoDao;
import pe.edu.upeu.sysrubricas.dao.PersonaDao;
import pe.edu.upeu.sysrubricas.dao.UsuarioDao;
import pe.edu.upeu.sysrubricas.entity.Acceso;
import pe.edu.upeu.sysrubricas.entity.Persona;
import pe.edu.upeu.sysrubricas.entity.Usuario;



@Component
public class InfoAdicionalToken implements TokenEnhancer{
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private AccesoDao accesoDao;
	@Autowired
	private PersonaDao personaDao;
Gson g = new Gson();
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Usuario user = usuarioDao.read(authentication.getName());
		Persona per = personaDao.read(user.getPersona_id());
		List<Acceso> accesos = new ArrayList<>();
		accesos = accesoDao.getAccesosbyid(user.getPersona_id());
		Map<String, Object> datos= new HashMap<>();
		datos.put("iduser", user.getPersona_id());
		datos.put("nombre", per.getNombres());
		datos.put("apellidos",per.getApellidos());
		datos.put("user", user.getUsername());
		datos.put("accesos", accesos);
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(datos);

		return accessToken;
	}

}
