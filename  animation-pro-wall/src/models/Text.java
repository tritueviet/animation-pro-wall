/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

/**
 *
 * @author TRITUEVIET
 */
public class Text {
    public static String[] custom0={"  mixed with pictures","  yellow","  red","  purple","  blue","  green","  light blue","  gray"};
    public static String[] custom1={"  trộn cùng ảnh","  vàng","  đỏ","  tím","  xanh dương","  xanh lá cây","  xanh nhạt", "  xám"};
    
    public static String[] hieuUng0={"  normal","  grey","  negative","  yellow ciphertext","  pale yellow","  blue","  red", "  custom effects"};
    public static String[] hieuUng1={"  bình thường","  xám hóa","  âm bản","  vàng hóa","  vàng nhạt","  xanh dương","  đỏ", "  hiệu ứng tùy chỉnh"};
    public static String saveTo= "save to: ";
    public static String numberTakePhotho= "number take photos:";
    public static String eurro = "error";
    public static String read = "read";
    public static String write = "write";
    public static String hide = "hide";
    public static String camera = "camera";
    public static String regular = "regular file";
    public static String director = "directory";
    public static String open = "open";
    public static String neww = "new";
    public static String delete = "delete";
    public static String ok = "ok";
    public static String deletee = "delete";
    public static String profi = "properties ";
    public static String backChoose = "back choose type";
    public static String chooseType = "choose type";
    public static String inputSize = "input size new";
    public static String teext = "text";
    public static String select = "select";
    public static String ticker = "--> Việt Nam <--";
    public static String addNewImgW = "add new image width ";
    public static String addNewImgH = "add new image height ";
    public static String efect = "effects";
    public static String addtext = "add text";
    public static String event = "events";
    public static String yes = "yes";
    public static String no = "no";
    public static String color = "color";
    public static String size = "sizes";
    public static String style = "styles";
    public static String small = "small";
    public static String medium = "medium";
    public static String large = "large";
    public static String plain = "plain";
    public static String bold = "bold";
    public static String italic = "italic";
    public static String sparkling = "sparkling";
    public static String normal = "normal";
    public static String onePicture = "one picture";
    public static String morePicture = "more picture";
    public static String choose = "choose";
    public static String addNextPicture = "add next picture";
    public static String finish = "finish";
    public static String youNeedTo = "you need to grant access to application data. To grant access to read and modify the data.";
    public static String fileNameis = "file name is empty. Please provide file name";
    public static String canNotDeleteTheUpDerec = "can not delete The up-directory (..) " + "symbol! not a real folder";
    public static String canNotDeleTheNon = "can not delete The non-empty folder: ";
    public static String canNotAcc = "can not access/delete file";
    public static String fileDoesNot = "file does not exists";
    public static String attributes = "attributes";
    public static String location = "location";
    public static String type = "type ";
    public static String modified = "modified";
    public static String newFile = "new file";
    public static String enterName = "enter name ";
    public static String enterFileType = "enter file type ";
    public static String canNotCreatFile = "can not create file '";
    public static String next = "next";
    public static String build = "build";
    public static String addNameOfAnimal = "add name of animal";
    public static String addMoreEff = "add more effect";
    public static String pleaTypeYour = "please type your name";
    public static String save = "save";
    public static String results = "results";
    public static String successful = "successful";
    public static String failed = "failed";
    public static String about = "help & about";
    public static String setting = "setting";
    public static String lang = "languages";
    public static String reset = "reset";
    public static String loi = "messenger";
    public static String textLoi = "a name is the alphabet or number";
    
    public static String[] name_effects = {"snow", "rain", "leaves", "ping stars", "autumn leaves",
        "rain of flowers", "gold heart", "rose garden", "flower", "blue flower", "blue heart",
        "blue rain", "greenflower", "flower", "flame", "ping heart", "butterfly 2",
        "smallstar", "sparkling", "flowers stars", "rose", "butterfly"};
    public static String[] name_events = {"butterfly", "elf", "butterfly 0", "butterfly 1", "butterfly 2",
        "butterfly 3", "butterfly 4", "butterfly 5", "butterfly 6",
        "Woodpecker", "butterflies", "elf 2", "elf3", "hummingbirds", "retirement"};
    public static String[] monthList = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public static String chupp = "click";
    public static String thongbao = "phone will capture ";
    public static String thongbao1 =       " consecutive photos after pressing the capture";
    public static String info = "message";
    public static String Back = "back";
    public static String wait = "wait";
    public static String setUpEffect = "set up custom effects";
    public static String blendImage = "blend image";
    public static String valuee = "value";
    public static String typee = "type";
    public static String done = "done";
    
    
    public static int languages = 0;
    public static int effect = 0;
    public static int so = 7;
    public static int numberTake = 3;
    public static int imageNumber = 0;
    public static int value = 0;
    public static int typeEfect = 0;
    
    public void doiNgonNgu(int lang) {
        if (lang == 0) {
            this.loi="tin nhắn";
            this.textLoi="tên là chữ cái hoặc số";
            this.done="done";
            this.blendImage="blend image";
            this.typee="type";
            this.valuee="value";
            
            this.setUpEffect = "set up custom effects";
            this.saveTo= "save to: ";
            this.reset = "reset";
            this.eurro = "error";
            this.numberTakePhotho = "number take photos:";
            this.read = "read";
            this.write = "write";
            this.hide = "hide";
            this.camera = "camera";
            this.regular = "regular file";
            this.director = "directory";
            this.open = "open";
            this.neww = "new";
            this.delete = "delete";
            this.ok = "ok";
            this.deletee = "delete";
            this.profi = "properties ";
            this.backChoose = "back choose type";
            this.chooseType = "choose type";
            this.inputSize = "input size new";
            this.teext = "text";
            this.select = "select";
            this.ticker = "--> Việt Nam <--";
            this.addNewImgW = "add new image width ";
            this.addNewImgH = "add new image height ";
            this.efect = "effects";
            this.addtext = "add text";
            this.event = "events";
            this.yes = "yes";
            this.no = "no";
            this.color = "color";
            this.size = "sizes";
            this.style = "styles";
            this.small = "small";
            this.medium = "medium";
            this.large = "large";
            this.plain = "plain";
            this.bold = "bold";
            this.italic = "italic";
            this.sparkling = "sparkling";
            this.normal = "normal";
            this.onePicture = "one picture";
            this.morePicture = "more picture";
            this.choose = "choose";
            this.addNextPicture = "add next picture";
            this.finish = "finish";
            this.youNeedTo = "you need to grant access to application data. To grant access to read and modify the data.";
            this.fileNameis = "file name is empty. Please provide file name";
            this.canNotDeleteTheUpDerec = "can not delete The up-directory (..) " + "symbol! not a real folder";
            this.canNotDeleTheNon = "can not delete The non-empty folder: ";
            this.canNotAcc = "can not access/delete file";
            this.fileDoesNot = "file does not exists";
            this.attributes = "attributes";
            this.location = "location";
            this.type = "type ";
            this.modified = "modified";
            this.newFile = "new file";
            this.enterName = "enter name ";
            this.enterFileType = "enter file type ";
            this.canNotCreatFile = "can not create file '";
            this.next = "next";
            this.build = "build";
            this.addNameOfAnimal = "add name of animal";
            this.addMoreEff = "add more effect";
            this.pleaTypeYour = "please type your name";
            this.save = "save";
            this.results = "results";
            this.successful = "successful";
            this.failed = "failed";
            this.about = "help & about";
            this.setting = "setting";
            this.lang= "languages";
//            String[] name_effects = {"snow", "rain", "leaves", "ping stars", "autumn leaves",
//            "rain of flowers", "gold heart", "rose garden", "flower", "blue flower", "blue heart",
//            "blue rain", "greenflower", "flower", "flame", "ping heart", "butterfly 2",
//            "smallstar", "sparkling", "flowers stars", "rose", "butterfly"};
//            String[] name_events = {"butterfly", "elf", "butterfly 0", "butterfly 1", "butterfly 2",
//            "butterfly 3", "butterfly 4", "butterfly 5", "butterfly 6",
//            "Woodpecker", "butterflies", "elf 2", "elf3", "hummingbirds", "retirement"};
//            String[] monthList = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
            this.chupp = "click";
            this.thongbao = "phone will capture " ;
            this.thongbao1 =         " consecutive photos after pressing the capture";
            this.info = "message";
            this.Back = "back";
            this.wait = "wait";
            
            
        } else {
            this.loi="messenger";
            this.textLoi="a name is the alphabet or number";
            this.done="xong";
            this.blendImage="pha trộn ảnh";
            this.typee="loại";
            this.valuee="giá trị";
            this.setUpEffect = "cài đặt hiệu ứng đặc biệt";
            this.saveTo= "lưu tại: ";
            this.numberTakePhotho= "số lần chụp ảnh: ";
             this.reset = "làm lại";
            this.eurro = "lỗi";
            this.read = "đọc";
            this.write = "ghi";
            this.hide = "ẩn";
            this.camera = "camera";
            this.regular = "tệp thông thường";
            this.director = "thư mục";
            this.open = "mở";
            this.neww = "tạo mới";
            this.delete = "xóa";
            this.ok = "chấp nhận";
            this.deletee = "xóa";
            this.profi = "thuộc tính ";
            this.backChoose = "quay về chọn loại";
            this.chooseType = "chọn loại";
            this.inputSize = "nhập kích thước mới";
            this.teext = "chữ";
            this.select = "chọn";
            this.ticker = "--> Việt Nam <--";
            this.addNewImgW = "nhập chiều rộng ảnh mới ";
            this.addNewImgH = "nhập chiều dài ảnh mới ";
            this.efect = "hiệu ứng";
            this.addtext = "thêm chữ";
            this.event = "sự kiện";
            this.yes = "có";
            this.no = "không";
            this.color = "màu";
            this.size = "kích thước";
            this.style = "phong cách";
            this.small = "nhỏ";
            this.medium = "trung bình";
            this.large = "lớn";
            this.plain = "bình thường";
            this.bold = "đậm";
            this.italic = "nghiêng";
            this.sparkling = "lấp lánh";
            this.normal = "bình thường";
            this.onePicture = "từ một ảnh";
            this.morePicture = "từ nhiều ảnh";
            this.choose = "chọn";
            this.addNextPicture = "thêm ảnh tiếp theo";
            this.finish = "kết thúc";
            this.youNeedTo = "bạn cần phải cấp quyền truy cập dữ liệu ứng dụng. Để cấp quyền truy cập để đọc và sửa đổi dữ liệu.";
            this.fileNameis = "tên tập tin trống. Vui lòng cung cấp tên tập tin";
            this.canNotDeleteTheUpDerec = "không thể xóa. Thư mục lên (..)  "+"biểu tượng! không phải là một thư mục thực";
            this.canNotDeleTheNon = "không thể xóa Thư mục rỗng: ";
            this.canNotAcc = "không thể truy cập/xóa tập tin";
            this.fileDoesNot = "tệp tin không tồn tại";
            this.attributes = "đặc tính";
            this.location = "vị trí";
            this.type = "loại ";
            this.modified = "sửa đổi";
            this.newFile = "tệp mới";
            this.enterName = "nhập tên ";
            this.enterFileType = "nhập loại tệp ";
            this.canNotCreatFile = "không thể tạo tệp '";
            this.next = "tiếp theo";
            this.build = "xây dựng";
            this.addNameOfAnimal = "nhập tên của ảnh động";
            this.addMoreEff = "thêm hiệu ứng";
            this.pleaTypeYour = "vui lòng nhập tên";
            this.save = "lưu";
            this.results = "kết quả";
            this.successful = "thành công";
            this.failed = "không thành";
            this.about = "giúp đỡ & thông tin";
            this.setting = "cài đặt";
            this.lang= "ngôn ngữ";
//            String[] name_effects = {"snow", "rain", "leaves", "ping stars", "autumn leaves",
//            "rain of flowers", "gold heart", "rose garden", "flower", "blue flower", "blue heart",
//            "blue rain", "greenflower", "flower", "flame", "ping heart", "butterfly 2",
//            "smallstar", "sparkling", "flowers stars", "rose", "butterfly"};
//            String[] name_events = {"butterfly", "elf", "butterfly 0", "butterfly 1", "butterfly 2",
//            "butterfly 3", "butterfly 4", "butterfly 5", "butterfly 6",
//            "Woodpecker", "butterflies", "elf 2", "elf3", "hummingbirds", "retirement"};
//            String[] monthList = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
            this.chupp = "chụp";
            this.thongbao = "điện thoại sẽ chụp ";
            this.thongbao1=        " ảnh liên tiếp sau khi nhấn chụp";
            this.info = "tin nhắn";
            this.Back = "quay lại";
            this.wait = "chờ đợi";
        }
    }
}
