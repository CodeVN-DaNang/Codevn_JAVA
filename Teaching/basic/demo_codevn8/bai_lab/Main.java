import controller.MainController;

public class Main {
    public static void main(String[] args) {
        String[] mc = {"Nhập danh sách nhân viên từ bàn phím", "Xuất Danh sách theo loại nhân viên ra màn hình", "Sắp xếp giảm dần theo lương và xuất ra màn hình", "Tìm và xóa nhân viên theo tên nhập từ bàn phím", "Xuất mức lương trung bình của từng loại nhân viên"};
        MainController mainController = new MainController("OFFICE MANAGEMENT", mc);
        mainController.run();;
    }
}
