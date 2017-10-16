var bookLibraryModule = angular.module("bookLibrary", []);

bookLibraryModule.controller("LoadBooksCtrl", loadBookCtrl);

function loadBookCtrl() {
    this.result = 'works';
}