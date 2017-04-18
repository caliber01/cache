package ua.nure.cache.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.cache.entity.*;
import ua.nure.cache.repository.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordGenerator {

	private XWPFDocument document;
	private final Project project;

	public WordGenerator(final Project project) {
    	this.project = project;
    }

	public synchronized void generateDoc() throws IOException, InvalidFormatException {
		File file = new File("template.docx");
		FileInputStream fis = new FileInputStream(file);
		document = new XWPFDocument(fis);
		FileOutputStream out = new FileOutputStream(new File("report.docx"));
		generateTitle("1 АНАЛИЗ И КОНЦЕПТАЛЬНОЕ МОДЕЛИРОВАНИЕ ПРЕДМЕТНОЙ ОБЛАСТИ");
		insertSmallTitle("1.1 Анализ предметной области");
		insertContent("Здесь можно вставить текст того документа, " + "на основании которого проводился анализ.");
		insertSmallTitle("1.2 Концептуальное моделирование предметной области");
		insertContent("Основным компонентами концептуальной модели являются:");
		createHyphenatedList(Arrays.asList("описание функциональной структуры системы;",
				"описание объектов предметной области и связей между ними;",
				"описание информационных потребностей пользователей;", "описание существующего документооборота;",
				"описание алгоритмических зависимостей;", "описание ограничений целостности;",
				"описание лингвистических отношений."));
		createJustifyiedList(

		Arrays.asList("Проведем концептуальное моделирование нашей предметной области.",
				"Пользователями системы являются:"));
		// Actors List from the diagram
		insertActors();
		createJustifyiedList(Arrays.asList("", "Пользователи могут выполнять в системе следующие функции: ",
				"секретари -  фиксируют результаты обучения студентов;", "актер – его функция."));
		// Functions of the actor;
		createJustifyiedList(

		Arrays.asList("На рисунке 1.1 приведена Use-case  диаграмма системы, "
				+ "которая отражает функции пользователей в системе, "
				+ "что можно рассматривать как ее функциональную структуру.", ""));
		insertImage("useCase.jpg"); // test image

		generateTitle("Рисунок 1.1 - Use-case  диаграмма системы");
		createJustifyiedList(Arrays.asList("", "<здесь могут быть более развернутые пояснения по диаграмме>", "",
				"Проведем описание объектов предметной области и связей между ними. Основными объектами предметной области являются:"));
		// Objects
		createHyphenatedList(getElementNames());
		// Objects avec attributes
		insertObjWithAttr(document);

		createJustifyiedList(Arrays.asList("", "На рисунке 1.2 приведена схема взаимодействия объектов системы.", ""));
		insertImage("objectRelation.jpg");// test image
		generateTitle("Рисунок 1.2 -  Схема взаимосвязи объектов предметной области");
		createJustifyiedList(Arrays.asList("", "Между объектами существуют следующие связи: ", ""));

		insertIntegrConstr();
		// SrchFiltSorts etc
		createJustifyiedList(Arrays.asList("",
				"Информационными потребностями пользователей " + "являются потребности в сортировке, "
						+ "поиске, фильтрации информации и получении статистики, а именно:",
				"а) сортировка информации о следующих объектах по их атрибутам: "));
		insertSorts();
		createJustifyiedList(Arrays.asList("б) поиск информации о следующих объектах по их атрибутам:"));
		insertSearches();
		createJustifyiedList(Arrays.asList("в) фильтрация информации о следующих объектах по их атрибутам: "));
		insertFilters();
		// Statistic

		createJustifyiedList(Arrays
				.asList("У пользователей существует потребность " + "получения разного рода статистики, а именно:"));
		insertStat();
		// Отчет
		createJustifyiedList(
				Arrays.asList("", "В предметной области для работы необходимы ряд документов, например: "));
		insertReports();

		// AlgDep
		createJustifyiedList(Arrays.asList("",
				"При представлении информации пользователю некоторые порции "
						+ "информации требуют математической (или алгоритмической) обработки. "
						+ "Таким образом, в предметной области существуют следующие алгоритмические зависимости:"));
		insertAlgDeps();

		createJustifyiedList(Arrays.asList("",
				"При рассмотрении атрибутов объектов " + "из предметной области можно выделить следующие ограничения, "
						+ "которые накладываются предметной областью (ограничения целостности). ",
				"Следующие ограничения описывают требования уникальности, а именно:"));
		insertAttrConstr();

		createJustifyiedList(Arrays.asList("", "Следующие ограничения описывают требования,"
				+ " которые касаются связей между объектами предметной области, а именно:"));
		insertLinks();
		// сюда вставить ссылки

		createJustifyiedList(Arrays.asList("",
				"В данной предметной области существует "
						+ "ряд наименований объектов, которые специфичны для данной предметной области и могут "
						+ "быть отнесены к терминологии, которая должна быть учтена при составлении интерфейса приложения,"
						+ " а именно: ",
				"Здесь вставляются описания терминов типа", "- объект объект – это определение; ", "",
				"Кроме того, данная предметная область требует существенного облегчения некоторых процессов работы с информацией, "
						+ "что можно решить путем автоматизации такого рода деятельности.",
				"<здесь Вы должны вставить описание задачи автоматизации>"));
		document.createParagraph().createRun().addBreak(BreakType.PAGE);

		generateTitle("2 ПОСТАНОВКА ЗАДАЧИ");
		createJustifyiedList(Arrays.asList("",
				"На основании проведенного анализа и концептуального моделирования может "
						+ "быть сформулирована следующая постановка задачи на разработку информационной системы. "
						+ "Программная система должна поддерживать следующие функции: ",
				"- система должна отображать данные:"));

		doSmth();

		getAlgDepsNames();

		document.createParagraph().createRun().addBreak(BreakType.PAGE);
		generateTitle("3 ПРОЕКТИРОВАНИЕ БАЗЫ ДАННЫХ");
		insertSmallTitle("3.1 UML-моделирование");
		insertImage("er.jpg");
		createJustifyiedList(Arrays.asList("", "<здесь Вы должны вставить описания и рисунки с диаграммами>"));
		insertSmallTitle("3.2 Построение ER-диаграммы");
		createJustifyiedList(
				Arrays.asList("", "<здесь Вы должны вставить краткое описание, как Вы строили ER-диаграмму>",
						"На рисунке 3.3 приведена ER-диаграмм для базы данных."));
		insertImage("er.jpg");
		generateTitle("Рисунок 3.3 - ER-диаграмма предметной области");
		document.write(out);
		out.close();
		System.out.println("createparagraph.docx written successfully");
	}

	private void generateTitle(String text) {
		XWPFParagraph paragraph = document.createParagraph();
		paragraph.setAlignment(ParagraphAlignment.CENTER);
		paragraph.setSpacingAfter(0);
		paragraph.setSpacingBefore(0);
		XWPFRun run = paragraph.createRun();
		run.setFontFamily("Times New Roman");
		run.setFontSize(14);
		run.setText(text);
	}

	private void insertSmallTitle(String text) {
		XWPFParagraph paragraph = document.createParagraph();
		paragraph.setAlignment(ParagraphAlignment.BOTH);
		paragraph.setSpacingAfter(0);
		paragraph.setSpacingBefore(0);
		paragraph.setIndentationFirstLine(710);
		XWPFRun run = paragraph.createRun();
		run.setFontFamily("Times New Roman");
		run.setFontSize(14);
		run.setText(text);
	}

	private void insertContent(String text) {
		XWPFParagraph paragraph = document.createParagraph();
		paragraph.setAlignment(ParagraphAlignment.BOTH);
		paragraph.setSpacingAfter(0);
		paragraph.setSpacingBefore(0);
		paragraph.setIndentationFirstLine(710);
		XWPFRun run = paragraph.createRun();
		run.setFontFamily("Times New Roman");
		run.setFontSize(14);
		run.setText(text);
	}

	private void createNumericList(List<String> items, int intendation) {
		for (int i = 1; i <= items.size(); i++) {
			XWPFParagraph paragraph = document.createParagraph();
			paragraph.setAlignment(ParagraphAlignment.BOTH);
			paragraph.setSpacingAfter(0);
			paragraph.setSpacingBefore(0);
			paragraph.setIndentationFirstLine(intendation);
			XWPFRun run = paragraph.createRun();
			run.setFontFamily("Times New Roman");
			run.setFontSize(14);
			run.setText(i + ") " + items.get(i - 1));
		}
	}

	private void createHyphenatedList(List<String> items) {
		for (int i = 1; i <= items.size(); i++) {
			XWPFParagraph paragraph = document.createParagraph();
			paragraph.setAlignment(ParagraphAlignment.BOTH);
			paragraph.setSpacingAfter(0);
			paragraph.setSpacingBefore(0);
			paragraph.setIndentationFirstLine(0);
			XWPFRun run = paragraph.createRun();
			run.setFontFamily("Times New Roman");
			run.setFontSize(14);
			run.setText("— " + items.get(i - 1));
		}
	}

	private void createJustifyiedList(List<String> items) {
		for (int i = 1; i <= items.size(); i++) {
			XWPFParagraph paragraph = document.createParagraph();
			paragraph.setAlignment(ParagraphAlignment.BOTH);
			paragraph.setSpacingAfter(0);
			paragraph.setSpacingBefore(0);
			paragraph.setIndentationFirstLine(710);
			XWPFRun run = paragraph.createRun();
			run.setFontFamily("Times New Roman");
			run.setFontSize(14);
			run.setText(items.get(i - 1));
		}
	}

	private void insertImage(String imgName) throws InvalidFormatException, IOException {
		XWPFParagraph title = document.createParagraph();
		XWPFRun run = title.createRun();
		title.setAlignment(ParagraphAlignment.LEFT);
		String imgFile = imgName;
		try {
			FileInputStream is = new FileInputStream(imgFile);
			run.addBreak();
			run.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, imgFile, Units.toEMU(424), Units.toEMU(236));
		}catch (FileNotFoundException ex) {

		}
	}

	private List<String> getElementNames() {
		return this.project.getEntities().stream()
				.map(Entity::getName)
				.collect(Collectors.toList());
	}

	private void insertObjWithAttr(XWPFDocument document) {
		List<String> names = this.project.getEntities().stream().map(obj -> {
			StringBuilder sb = new StringBuilder();
			sb.append("Объект \"");
			sb.append(obj.getName());
			sb.append("\" имеет следующие атрибуты: ");
			for (Attribute attr : obj.getAttrs()) {
				sb.append("\"");
				sb.append(attr.getName());
				sb.append("\"; ");
			}
			return sb.toString();
		}).collect(Collectors.toList());
		createJustifyiedList(names);
	}

	private void insertIntegrConstr() {
		List<String> names = this.project.getLinkConstraints().stream().map(obj -> {
			StringBuilder sb = new StringBuilder();
			sb.append("—Между \"");
			sb.append(obj.getFirstEntity().getName());
			sb.append("\" и \"");
			sb.append(obj.getSecondEntity().getName());
			sb.append("\" связь \"");
			sb.append(obj.getComment());
			sb.append("\" ");
			return sb.toString();
		}).collect(Collectors.toList());
		createJustifyiedList(names);
	}

	private void insertSorts() {
		List<String> names = this.project.getInformationalRequirements()
				.stream()
				.filter(infReq -> infReq.getType().equals(InformationalRequirement.Type.SORT))
                .map(obj -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Объект \"");
                    sb.append(new ArrayList<>(obj.getAttributes()).get(0).getName());
                    sb.append("\" по атрибутам: ");
                    for (Attribute attr : obj.getAttributes()) {
                        sb.append("\"");
                        sb.append(attr.getName());
                        sb.append("\"; ");
                    }
                    return sb.toString();
                })
                .collect(Collectors.toList());
		createNumericList(names, 1420);
	}

	private void insertSearches() {
        List<String> names = this.project.getInformationalRequirements()
                .stream()
                .filter(infReq -> infReq.getType().equals(InformationalRequirement.Type.SEARCH))
                .map(obj -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Объект \"");
                    sb.append(this.extractElement(obj).getName());
                    sb.append("\" по атрибутам: ");
                    for (Attribute attr : obj.getAttributes()) {
                        sb.append("\"");
                        sb.append(attr.getName());
                        sb.append("\"; ");
                    }
                    return sb.toString();
                })
                .collect(Collectors.toList());
		createNumericList(names, 1420);
	}

	private void insertFilters() {
        List<String> names = this.project.getInformationalRequirements()
                .stream()
                .filter(infReq -> infReq.getType().equals(InformationalRequirement.Type.FILTER))
                .map(obj -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Объект \"");
                    sb.append(this.extractElement(obj));
                    sb.append("\" по атрибутам: ");
                    for (Attribute attr : obj.getAttributes()) {
                        sb.append("\"");
                        sb.append(attr.getName());
                        sb.append("\"; ");
                    }
                    return sb.toString();
                })
                .collect(Collectors.toList());
		createNumericList(names, 1420);
	}

	private void insertStat() {
		List<String> names = project.getStatistics().stream().map(obj -> {
			StringBuilder sb = new StringBuilder();
			sb.append("Статистика \"");
			sb.append(obj.getName());
			sb.append("\", которая содержит следующую информацию: ");
			for (Entity o : obj.getEntities()) {
				sb.append("атрибуты: ");
				for (Attribute a : o.getAttrs()) {
					sb.append("\"");
					sb.append(a.getName());
					sb.append("\";");
				}
				sb.append("из объекта \"");
				sb.append(o.getName());
				sb.append("\";");
			}
			return sb.toString();
		}).collect(Collectors.toList());
		createHyphenatedList(names);
	}

	private void insertReports() {
		List<String> names = project.getReports().stream().map(obj -> {
			StringBuilder sb = new StringBuilder();
			sb.append("Документ \"");
			sb.append(obj.getName());
			sb.append("\", который содержит следующую информацию: ");
			for (Entity o : obj.getEntities()) {
				sb.append("атрибуты: ");
				for (Attribute a : o.getAttrs()) {
					sb.append("\"");
					sb.append(a.getName());
					sb.append("\";");
				}
				sb.append("из объекта \"");
				sb.append(o.getName());
				sb.append("\";");
			}
			return sb.toString();
		}).collect(Collectors.toList());
		createHyphenatedList(names);
	}

	private void insertAlgDeps() {
		final List<String> names = project.getAlgDeps().stream().map(obj -> {
			StringBuilder sb = new StringBuilder();
			sb.append("Атрибут \"");
			sb.append(obj.getResultField().getName());
			sb.append("\", который вычисляется на основании следующих атрибутов по формуле: ");
			sb.append(obj.getFormula());
			sb.append(" где ");
			for (SourceField sf : obj.getSourceFields()) {
				sb.append(sf.getVariable());
				sb.append(" - \"");
				sb.append(sf.getAttribute().getName());
				sb.append("\" из \"");
				sb.append(sf.getAttribute().getName());
				sb.append("\"; ");
			}
            return sb.toString();
		}).collect(Collectors.toList());
		createHyphenatedList(names);
	}

	private void insertAttrConstr() {
		List<String> names = project.getAttrConstraints().stream().map(obj -> {
			StringBuilder sb = new StringBuilder();
			sb.append("Для объекта  \"");
			sb.append(obj.getAttribute().getName());
			sb.append("\", атрибут  \"");
			sb.append(obj.getAttribute().getName());
			sb.append("\" является уникальным");
            return sb.toString();
		}).collect(Collectors.toList());
		createHyphenatedList(names);
	}

	private void doSmth() {
		StringBuilder sb = new StringBuilder();
		List<String> names = new ArrayList<>();
		sb.append("непосредственно о главных объектах: ");
		for (String name : getElementNames()) {
			sb.append(name);
			sb.append("; ");
		}
		names.add(sb.toString());
		sb = new StringBuilder();
		sb.append("о связанных объектах: ассоциация из ER-диаграммы");
		names.add(sb.toString());
		createNumericList(names, 1420);
	}

	private void getAlgDepsNames() {
		StringBuilder sb = new StringBuilder();
		sb.append("система должна поддерживать арифметическую обработку данных в виде вычислений полей: ");
		project.getAlgDeps().forEach(obj -> {
			sb.append(" \"");
			sb.append(obj.getName());
			sb.append("\" ");
		});
		createHyphenatedList(
				Arrays.asList(sb.toString(), "система должна поддерживать сортировку, поиск и фильтрация данных:"));
		createJustifyiedList(Arrays.asList(
				"Здесь вставляется кусок об информационных потребностях из раздела 1.2, только с изменением списков по ГОСТам"));
		createJustifyiedList(Arrays.asList("", "а) сортировка информации о следующих объектах по их атрибутам: "));
		insertSorts();
		createJustifyiedList(Arrays.asList("б) поиск информации о следующих объектах по их атрибутам:"));
		insertSearches();
		createJustifyiedList(Arrays.asList("в) фильтрация информации о следующих объектах по их атрибутам: "));
		insertFilters();
		createHyphenatedList(Arrays.asList("система должна поддерживать добавление новых данных о (список объектов)",
				"система должна поддерживать возможность редактировать информацию о (список объектов)",
				"система должна поддерживать возможность удалять информацию о (список объектов)",
				"система должна поддерживать следующие часто возникающие запросы:"));

		createJustifyiedList(Arrays.asList(
				"Здесь вставляется кусок об информационных потребностях из раздела 1.2, только с изменением списков по ГОСТам"));
		insertStat();
		createHyphenatedList(Arrays.asList(
				"система должна поддерживать возможность формирования "
						+ "произвольных запросов в базы данных язык SQL с поддержкой для пользователя сведения о схеме DB;",
				"система должна поддерживать подготовку и печать следующих отчетов:"));
		insertReports();
		createHyphenatedList(Arrays.asList("система должна реализовывать следующую задачу автоматизации: ",
				"<здесь Вы должны вставить описание задачи автоматизации>"));
	}

	private void insertLinks() {
		List<String> names = this.project.getLinks().stream()
                .map(Link::returnDesr)
                .collect(Collectors.toList());
		createHyphenatedList(names);
	}

	private void insertActors() {

		createHyphenatedList(this.project.getActors().stream()
                .map(Actor::getName)
				.collect(Collectors.toList()));
	}

	private Entity extractElement(final InformationalRequirement requirement) {
		return new ArrayList<>(requirement.getAttributes()).get(0).getEntity();
	}
}