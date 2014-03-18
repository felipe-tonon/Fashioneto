package com.fashioneto.ws.json;

import java.lang.reflect.Type;

import com.fashioneto.persistence.Comment;
import com.fashioneto.ws.entities.LikesWrapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @author Felipe Tonon 6 Feb 2014
 **/
public class CommentJsonSerializer implements JsonSerializer<Comment>
{

	public static final String JSON_PROPERTY_ID = "id";
	public static final String JSON_PROPERTY_CONTENT = "content";
	public static final String JSON_PROPERTY_COMMENTS = "commentsWrapper";
	public static final String JSON_PROPERTY_USER_ID = "userId";
	public static final String JSON_PROPERTY_USER_NAME = "userName";
	public static final String JSON_PROPERTY_LIKES = "likes";
	public static final String JSON_PROPERTY_DATE = "date";

	private JsonElement getJsonFromComment(Comment comment, JsonSerializationContext context)
	{
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(JSON_PROPERTY_ID, comment.getId());
		jsonObject.addProperty(JSON_PROPERTY_CONTENT, comment.getContent());
		jsonObject.addProperty(JSON_PROPERTY_USER_ID, comment.getUser().getId());
		jsonObject.addProperty(JSON_PROPERTY_USER_NAME, comment.getUser().getUsername());
		jsonObject.addProperty(JSON_PROPERTY_DATE, comment.getDateInTimestampString());

		jsonObject.add(JSON_PROPERTY_COMMENTS, context.serialize(comment.getCommentsCommentSet()));
		jsonObject.add(JSON_PROPERTY_LIKES, context.serialize(getLikesWrapper(comment)));

		return jsonObject;
	}

	private LikesWrapper getLikesWrapper(Comment comment)
	{
		LikesWrapper likesWrapper = new LikesWrapper(comment.getNumberOfLikes(), false);
		return likesWrapper;
	}

	@Override
	public JsonElement serialize(Comment comment, Type arg1, JsonSerializationContext context)
	{

		return getJsonFromComment(comment, context);
	}

}
