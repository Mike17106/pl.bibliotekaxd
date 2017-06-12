angular.module('app')
.constant('RENT_ENDPOINT', '/api/rents/:token')
.factory('Rent', function($resource, RENT_ENDPOINT) {
	return $resource(RENT_ENDPOINT);
})
.service('Rents', function(Rent) {
	this.getAll = function() {
		return Rent.query();
	}
	this.get = function(index) {
		return Rent.get({token: index});
	}
	this.add = function(rent) {
		rent.$save();
	}
});