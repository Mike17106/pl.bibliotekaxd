angular.module('app')
.controller('RentlController', function(Books) {
	var vm = this;
	vm.books = Rents.getAll();
	console.log('lista załadowana');
	console.log(vm.rents)
});