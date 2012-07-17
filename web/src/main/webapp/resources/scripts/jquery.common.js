/**
* jQuery namespace
* 
**/
(function($){
	$.extend({
		namespace: function() {
			var o, d;
			$.each(arguments, function() {
				d = this.split(".");
				o = window[d[0]] = window[d[0]] || {};
				$.each(d.slice(1), function(){
					o = o[this] = o[this] || {};
				});
			});
			return o;
		}
	});
})(jQuery);