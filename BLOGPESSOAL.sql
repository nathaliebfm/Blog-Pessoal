-- MySQL Script generated by MySQL Workbench
-- Tue Sep 27 12:21:46 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema DB_BLOG_PESSOAL
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema DB_BLOG_PESSOAL
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DB_BLOG_PESSOAL` DEFAULT CHARACTER SET utf8 ;
USE `DB_BLOG_PESSOAL` ;

-- -----------------------------------------------------
-- Table `DB_BLOG_PESSOAL`.`TB_TEMAS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_BLOG_PESSOAL`.`TB_TEMAS` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `DESCRICAO` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_BLOG_PESSOAL`.`TB_USUARIOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_BLOG_PESSOAL`.`TB_USUARIOS` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(255) NOT NULL,
  `USUARIO` VARCHAR(255) NOT NULL,
  `SENHA` VARCHAR(8) NOT NULL,
  `FOTO` VARCHAR(255) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_BLOG_PESSOAL`.`TB_POSTAGENS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_BLOG_PESSOAL`.`TB_POSTAGENS` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `TITULO` VARCHAR(100) NOT NULL,
  `TEXTO` VARCHAR(1000) NOT NULL,
  `DATA` DATE NULL,
  `TB_TEMAS_ID` BIGINT NULL,
  `TB_USUARIOS_ID` BIGINT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_TB_POSTAGENS_TB_TEMAS_idx` (`TB_TEMAS_ID` ASC) VISIBLE,
  INDEX `fk_TB_POSTAGENS_TB_USUARIOS1_idx` (`TB_USUARIOS_ID` ASC) VISIBLE,
  CONSTRAINT `fk_TB_POSTAGENS_TB_TEMAS`
    FOREIGN KEY (`TB_TEMAS_ID`)
    REFERENCES `DB_BLOG_PESSOAL`.`TB_TEMAS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TB_POSTAGENS_TB_USUARIOS1`
    FOREIGN KEY (`TB_USUARIOS_ID`)
    REFERENCES `DB_BLOG_PESSOAL`.`TB_USUARIOS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;