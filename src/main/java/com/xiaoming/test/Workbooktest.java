//import org.apache.poi.ss.SpreadsheetVersion;
//import org.apache.poi.ss.formula.udf.UDFFinder;
//import org.apache.poi.ss.usermodel.*;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.Iterator;
//import java.util.List;
//
//public class Workbooktest implements Workbook {
//    public int getActiveSheetIndex() {
//        return 0;
//    }
//
//    public void setActiveSheet(int i) {
//
//    }
//
//    public int getFirstVisibleTab() {
//        return 0;
//    }
//
//    public void setFirstVisibleTab(int i) {
//
//    }
//
//    public void setSheetOrder(String s, int i) {
//
//    }
//
//    public void setSelectedTab(int i) {
//
//    }
//
//    public void setSheetName(int i, String s) {
//
//    }
//
//    public String getSheetName(int i) {
//        return null;
//    }
//
//    public int getSheetIndex(String s) {
//        return 0;
//    }
//
//    public int getSheetIndex(Sheet sheet) {
//        return 0;
//    }
//
//    public Sheet createSheet() {
//        return null;
//    }
//
//    public Sheet createSheet(String s) {
//        return null;
//    }
//
//    public Sheet cloneSheet(int i) {
//        return null;
//    }
//
//    public Iterator<Sheet> sheetIterator() {
//        return null;
//    }
//
//    public int getNumberOfSheets() {
//        return 0;
//    }
//
//    public Sheet getSheetAt(int i) {
//        return null;
//    }
//
//    public Sheet getSheet(String s) {
//        return null;
//    }
//
//    public void removeSheetAt(int i) {
//
//    }
//
//    public Font createFont() {
//        return null;
//    }
//
//    public Font findFont(short i, short i1, short i2, String s, boolean b, boolean b1, short i3, byte b2) {
//        return null;
//    }
//
//    public Font findFont(boolean b, short i, short i1, String s, boolean b1, boolean b2, short i2, byte b3) {
//        return null;
//    }
//
//    public short getNumberOfFonts() {
//        return 0;
//    }
//
//    public Font getFontAt(short i) {
//        return null;
//    }
//
//    public CellStyle createCellStyle() {
//        return null;
//    }
//
//    public int getNumCellStyles() {
//        return 0;
//    }
//
//    public CellStyle getCellStyleAt(int i) {
//        return null;
//    }
//
//    public void write(OutputStream outputStream) throws IOException {
//
//    }
//
//    public void close() throws IOException {
//
//    }
//
//    public int getNumberOfNames() {
//        return 0;
//    }
//
//    public Name getName(String s) {
//        return null;
//    }
//
//    public List<? extends Name> getNames(String s) {
//        return null;
//    }
//
//    public List<? extends Name> getAllNames() {
//        return null;
//    }
//
//    public Name getNameAt(int i) {
//        return null;
//    }
//
//    public Name createName() {
//        return null;
//    }
//
//    public int getNameIndex(String s) {
//        return 0;
//    }
//
//    public void removeName(int i) {
//
//    }
//
//    public void removeName(String s) {
//
//    }
//
//    public void removeName(Name name) {
//
//    }
//
//    public int linkExternalWorkbook(String s, Workbook workbook) {
//        return 0;
//    }
//
//    public void setPrintArea(int i, String s) {
//
//    }
//
//    public void setPrintArea(int i, int i1, int i2, int i3, int i4) {
//
//    }
//
//    public String getPrintArea(int i) {
//        return null;
//    }
//
//    public void removePrintArea(int i) {
//
//    }
//
//    public Row.MissingCellPolicy getMissingCellPolicy() {
//        return null;
//    }
//
//    public void setMissingCellPolicy(Row.MissingCellPolicy missingCellPolicy) {
//
//    }
//
//    public DataFormat createDataFormat() {
//        return null;
//    }
//
//    public int addPicture(byte[] bytes, int i) {
//        return 0;
//    }
//
//    public List<? extends PictureData> getAllPictures() {
//        return null;
//    }
//
//    public CreationHelper getCreationHelper() {
//        return null;
//    }
//
//    public boolean isHidden() {
//        return false;
//    }
//
//    public void setHidden(boolean b) {
//
//    }
//
//    public boolean isSheetHidden(int i) {
//        return false;
//    }
//
//    public boolean isSheetVeryHidden(int i) {
//        return false;
//    }
//
//    public void setSheetHidden(int i, boolean b) {
//
//    }
//
//    public void setSheetHidden(int i, int i1) {
//
//    }
//
//    public void addToolPack(UDFFinder udfFinder) {
//
//    }
//
//    public void setForceFormulaRecalculation(boolean b) {
//
//    }
//
//    public boolean getForceFormulaRecalculation() {
//        return false;
//    }
//
//    public SpreadsheetVersion getSpreadsheetVersion() {
//        return null;
//    }
//
//    public Iterator<Sheet> iterator() {
//        return null;
//    }
//}
