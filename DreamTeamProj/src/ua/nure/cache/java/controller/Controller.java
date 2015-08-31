package ua.nure.cache.java.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.cache.java.constants.DiagrTypes;
import ua.nure.cache.java.service.Server;

public class Controller {
	private static Logger log = Logger.getLogger(Controller.class);

	private static Map<String, Method> methods = new HashMap<String, Method>();
	
	private static Map<String, String> shtoto = new HashMap<String, String>();
	static {
		try {
			Class<?> cardManager = Server.class;
			Class<?> request = HttpServletRequest.class;
			Class<?> response = HttpServletResponse.class;
			shtoto.put("/diagrams/usecase", DiagrTypes.USE_CASE);
			shtoto.put("/diagrams/object_relations", DiagrTypes.OBJECT_RELATIONAL);
			shtoto.put("/diagrams/er", DiagrTypes.ER);
			
			methods.put("/objects/all", cardManager.getDeclaredMethod(
					"getAllObjects",  request, response));
			methods.put("/statistics/all", cardManager
					.getDeclaredMethod("getAllStatistics",  request,
							response));
			methods.put("/reports/all", cardManager.getDeclaredMethod(
					"getAllReports", request, response));
			methods.put("/diagrams/usecase", cardManager
					.getDeclaredMethod("getDiagramByType", String.class,  request,
							response));
			methods.put("/diagrams/object_relations", cardManager
					.getDeclaredMethod("getDiagramByType" , String.class,  request,
							response));
			methods.put("/diagrams/er", cardManager.getDeclaredMethod(
					"getDiagramByType", String.class, request, response));
			methods.put("/informational_requirements/searches/all",
					cardManager.getDeclaredMethod("getInformReqSorts", request, response));
			methods.put("/informational_requirements/sorts/all",
					cardManager.getDeclaredMethod("getInformReqSearches",
							 request, response));
			methods.put("/informational_requirements/filters/all",
					cardManager.getDeclaredMethod("getInformReqFilters", request, response));
			methods.put("/algorithmic_dependencies/all", cardManager
					.getDeclaredMethod("getAlgorithmicDep", request,
							response));
			methods.put("/objects/byId", cardManager
					.getDeclaredMethod("getObjById", request,
							response));

		} catch (Exception e) {
			System.out.println(e.getMessage());
			log.error(e);
		}
	}

	private static Method get(String commandName) {
		if (commandName == null || !methods.containsKey(commandName)) {
			return null;
		}
		return methods.get(commandName);
	}
	
	private static void routeDiagrTypes(Method m, String url,HttpServletRequest request,
			HttpServletResponse response ) {
		try {
			m.invoke(m.getDeclaringClass().newInstance(),shtoto.get(url), request, response);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | InstantiationException e) {
			log.error(e.getMessage());
		}
	}
	
	public static void routeIt(String url, HttpServletRequest request,
			HttpServletResponse response) {
		Method m = get(url);
		System.out.println(url);
		if (m==null) {
			return;
		}
		if (m.getName().equals("getDiagramByType")) {
			routeDiagrTypes(m, url,request,response);
			return;
		}
		try {
			m.invoke(m.getDeclaringClass().newInstance(), request, response);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | InstantiationException e) {
			log.error(e.getMessage());
		}
	}

}
