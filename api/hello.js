var shadow$provide = {};
(function(root, factory) {
  if (typeof define === "function" && define.amd) {
    define([], factory);
  } else if (typeof module === "object" && module.exports) {
    module.exports = factory();
  } else {
    root.returnExports = factory();
  }
})(this, function() {
  var shadow$umd$export = null;
/*

 Copyright The Closure Library Authors.
 SPDX-License-Identifier: Apache-2.0
*/
'use strict';shadow$umd$export=function(b,a){return a.status(200).send("hello world")};return shadow$umd$export;
});