define(function(require){

	var
	MasterBaseView = require( 'views/masterbaseview' ),
	Handlebars     = require("handlebars"),
	template       = require("text!templates/photos/album-thumbnail.hbr")
	PhotoModal     = require('views/photos/photo-modal');

	return MasterBaseView.extend({
		template: Handlebars.compile(template),
		events:{
			"click": function(){
				new PhotoModal( {collection : this.model.collection,
					model : this.model} );
			}
		}
	});

});