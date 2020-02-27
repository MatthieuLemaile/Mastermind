module Mastermind {
    exports fr.lemaile.mastermind.controller;
    exports fr.lemaile.mastermind.model;
    exports fr.lemaile.mastermind.ui;
    exports fr.lemaile.mastermind.ui.option;
    exports fr.lemaile.mastermind.ui.option.swing;
    exports fr.lemaile.mastermind.ui.about;
    exports fr.lemaile.mastermind.ui.board;
    exports fr.lemaile.mastermind.ui.board.swing;

    //UI
    requires java.datatransfer;
    requires java.desktop;

    //Logging
    opens fr.lemaile.mastermind;
    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;
    requires org.apache.logging.log4j.slf4j;
    requires org.slf4j;
    //Logging via yml file
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;
}