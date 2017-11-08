var bookLibraryModule = angular.module("bookLibrary", []);

bookLibraryModule.controller("LoadBooksCtrl", loadBookCtrl);
bookLibraryModule.controller("UploadBookCtrl", uploadBookCtrl);

function loadBookCtrl() {
    this.result = 'works';
}
