package com.blogbox.constants;

public class Const {
	
	private Const () {
	}
	
	public static final String PARAM_ID_USUARIO = "[idUsuario]";
	public static final String PARAM_ID_PUBLICACION = "[idPublicacion]";
	public static final String PARAM_ID_ALBUM = "[idAlbum]";
	
	public static final String URL_SERV_USUARIOS = "https://jsonplaceholder.typicode.com/users";
	public static final String URL_SERV_PUBLICACIONES = "https://jsonplaceholder.typicode.com/posts?userId="+PARAM_ID_USUARIO;
	public static final String URL_SERV_COMENTARIOS = "https://jsonplaceholder.typicode.com/posts/"+PARAM_ID_PUBLICACION+"/comments";
	public static final String URL_SERV_ALBUMES = "https://jsonplaceholder.typicode.com/albums?userId="+PARAM_ID_USUARIO;
	public static final String URL_SERV_FOTOS = "https://jsonplaceholder.typicode.com/photos?albumId="+PARAM_ID_ALBUM;
	
	public static final String VIEW_USERS = "users";
	public static final String VIEW_POSTS = "posts";
	public static final String VIEW_COMMENTS = "comments";
	public static final String VIEW_GALLERY = "galleries";
	public static final String VIEW_PHOTOS = "photos";
	
	public static final String REQ_USERS = "";
	public static final String REQ_POSTS = "/posts";
	public static final String REQ_GALLERY = "/gallery";
	
	public static final String SERV_USERS = "usersService";
	public static final String SERV_POSTS = "postService";
	public static final String SERV_GALLERY = "galeriesService";
	
	public static final String DEFAULT_PHOTO = "imgs/def_photo.jpg";
}
