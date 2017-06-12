angular.module('app')
.controller('nrentController', function(Books, Book) {
	var vm = this;
	vm.rent = new Rent();
	vm.saverent = function() {
		Rent.add(vm.rent);
		vm.rent = new Rent();
	}
});