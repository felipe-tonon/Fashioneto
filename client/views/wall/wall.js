define(function(require){

	var
	Backbone   = require("backbone"),
	Handlebars = require("handlebars"),
	$          = require("jquery"),
	
	template   = require("text!templates/wall/wall.hbr"),
	Posts      = require("views/wall/posts.js");


	return Backbone.View.extend({

		nodes:{
			posts: "#postDisplay"
		},

		template: Handlebars.compile( template ),

		initialize: function(){
			this.posts = new Posts();		
		},

		render: function(){
			this.$el
			.html( this.template() )
			.find( this.nodes.posts )
			.html( this.posts.render().el );
			return this;
		}
		
	});

});