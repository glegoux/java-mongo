// console.js
//
// librabry to print traces in color

function info(message) {
  var blue = String("\033[1;34m");
  var end = String("\033[0m");
  print(blue + "INFO: " +  message + end);
}

function warn(message) {
  var orange = String("\033[1;33m");
  var end = String("\033[0m");
  print(orange + "WARNING: " +  message + end);

}

function error(message) {
  var red = String("\033[1;31m");
  var end = String("\033[0m");
  print(red + "ERROR: " + message + end);
}

function success(message) {
  var green = String("\033[1;32m");
  var end = String("\033[0m");
  print(green + "SUCCESS: " + message + end);
}
