/* -*- Mode: Java; tab-width: 2; indent-tabs-mode: nil; c-basic-offset: 2 -*- */
/* vim: set shiftwidth=2 tabstop=2 autoindent cindent expandtab: */

"use strict";

var APP_BASE_DIR = "../../";

initFS.then(function() {
  fs.storeSync(function() {
    document.body.appendChild(document.createTextNode("DONE"));
  });
});
