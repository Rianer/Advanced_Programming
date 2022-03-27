package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

import java.awt.*;
import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog extends AddCommand implements SaveCommand, ListCommand, ViewCommand, LoadCommand, ReportCommand {

    public Catalog() {
    }

    public String getCatalogName() {
        return name;
    }

    public void setCatalogName(String name) {
        this.name = name;
    }

    public List<Item> getItemList() {
        return list;
    }

    public void setItemList(List<Item> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "list=" + list +
                '}';
    }

    @Override
    public void save(String path) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            mapper.writeValue(Paths.get(path).toFile(), this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void list() {
        for (Item iterator : list) {
            System.out.println(iterator);
        }
    }

    @Override
    public void view(String filePath) {
        try {
            Desktop desktop = Desktop.getDesktop();
            File myFile = new File(filePath);
            desktop.open(myFile);
        } catch (IOException ex) {
        }

    }

    public void load(String path) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Catalog auxCatalog = mapper.readValue(new File(path), Catalog.class);
            this.list = auxCatalog.list;
            this.name = auxCatalog.name;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void report() {
        try{
            Configuration cfg = new Configuration(new Version("2.3.23"));
            cfg.setClassForTemplateLoading(Catalog.class, "/");

            Template template = cfg.getTemplate("index.ftl");

            Map<String, Object> templateData = new HashMap<>();
            templateData.put("items", list);

            StringWriter out = new StringWriter();

            template.process(templateData, out);
            //System.out.println(out.getBuffer().toString());
            String output = out.toString();
            out.flush();

            FileWriter fileWriter = new FileWriter("index.html");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(output);
            printWriter.close();

            this.view("index.html");

        }
        catch (IOException | TemplateException e){
            e.printStackTrace();
        }
    }
}
