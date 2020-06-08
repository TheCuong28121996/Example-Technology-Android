package com.example.android.other

import com.example.android.R
import com.example.android.data.*

/**
 * @author TheCuong
 * @since 01/06/2018
 */
object DataSource {

    fun getUser() = ArrayList<User>().apply {
        add(
            User(
                1,
                "Himanshu",
                "https://s3.amazonaws.com/uifaces/faces/twitter/sunlandictwin/128.jpg"
            )
        )
        add(
            User(
                2,
                "Alford Hoeger",
                "https://s3.amazonaws.com/uifaces/faces/twitter/mufaddal_mw/128.jpg"
            )
        )
        add(
            User(
                3,
                "Terrance Halvorson",
                "https://s3.amazonaws.com/uifaces/faces/twitter/mufaddal_mw/128.jpg"
            )
        )
        add(
            User(
                3,
                "Morgan McGlynn",
                "https://s3.amazonaws.com/uifaces/faces/twitter/allfordesign/128.jpg"
            )
        )
        add(
            User(
                4,
                "Ms. Ramiro DuBuque",
                "https://s3.amazonaws.com/uifaces/faces/twitter/shaneIxD/128.jpg"
            )
        )
        add(
            User(
                5,
                "Kolby Orn",
                "https://s3.amazonaws.com/uifaces/faces/twitter/johnsmithagency/128.jpg"
            )
        )
        add(
            User(
                6,
                "Elijah Schoen MD",
                "https://s3.amazonaws.com/uifaces/faces/twitter/alxndrustinov/128.jpg"
            )
        )

    }

    fun getBanner() = Banner(R.drawable.image)

    fun getDeatail() =
        Detail(1, "Himanshu Singh", "I am an writer and Open Source contributor in MindOrks.")

    fun getListBanner() = ArrayList<BaseModel<BannerFood>>().apply {
        add(BaseModel(ArrayList<BannerFood>().apply {
            add(BannerFood("https://images.foody.vn/biz_banner/foody-upload-api-food-biz-200518110545.jpg"))
            add(BannerFood("https://images.foody.vn/biz_banner/foody-upload-api-food-biz-200603101545.jpg"))
            add(BannerFood("https://images.foody.vn/biz_banner/foody-upload-api-food-biz-200601144359.jpg"))
        }))
    }

    fun getListArticle() = ArrayList<BaseModel<BannerFood>>().apply {
        add(BaseModel(ArrayList<BannerFood>().apply {
            add(BannerFood("https://images.foody.vn/res/g103/1024279/prof/s380x244/foody-upload-api-foody-mobile-img_20200519_151424-200519154927.jpg"))
            add(BannerFood("https://images.foody.vn/res/g65/642367/prof/s380x244/foody-mobile-hmbbd-jpg-788-636246778311536484.jpg"))
            add(BannerFood("https://images.foody.vn/res/g101/1000319/prof/s380x244/foody-upload-api-foody-mobile-fbdbdbdbdbdbdbdbd-200302162551.jpg"))
        }))
    }

    fun getListForYou() = ArrayList<BaseModel<InfoFood>>().apply {
        add(BaseModel(ArrayList<InfoFood>().apply {
            add(
                InfoFood(
                    "Kai Coffee - Đường C18",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    10,
                    20,
                    "60%"
                )
            )
            add(
                InfoFood(
                    "BlackBall - Chè & Trà Sữa Đài Loan - Khu Du Lịch Bến Xưa",
                    "https://images.foody.vn/res/g86/855450/prof/s1242x600/foody-upload-api-foody-mobile-119626488-jpg-181130163617.jpg",
                    15,
                    20,
                    "30%"
                )
            )
            add(
                InfoFood(
                    "Oppa Milk Tea",
                    "https://images.foody.vn/res/g30/292890/prof/s1242x600/foody-mobile-foody-d-maris-buffet-301-636142012753318871.jpg",
                    0,
                    10,
                    "20%"
                )
            )
            add(
                InfoFood(
                    "Chợ Phố Fresh Food - Trái Cây Nhập Khẩu",
                    "https://images.foody.vn/res/g5/43892/prof/s1242x600/foody-mobile-_cqc9880-jpg-780-636118801575407376.jpg",
                    20,
                    40,
                    "80%"
                )
            )
            add(
                InfoFood(
                    "Cửa Hàng Trái Cây Farm Của Tùng",
                    "https://images.foody.vn/res/g100/996369/prof/s1242x600/foody-upload-api-foody-mobile-wdwd-200110113827.jpg",
                    10,
                    20,
                    "50%"
                )
            )
            add(
                InfoFood(
                    "Kai Coffee - Đường C18",
                    "https://images.foody.vn/res/g79/783117/prof/s1242x600/foody-upload-api-foody-mobile-29-191220093424.jpg",
                    10,
                    20,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Cá Hồi Annaseafresh - Phan Đình Phùng",
                    "https://images.foody.vn/res/g4/36729/prof/s1242x600/foody-upload-api-foody-mobile-3-200515150314.jpg",
                    5,
                    10,
                    "10%"
                )
            )
            add(
                InfoFood(
                    "Đặc Sản Nắng Gió - Thịt, Hải Sản & Khô Các Loại",
                    "https://images.foody.vn/res/g74/735585/prof/s1242x600/foody-upload-api-foody-mobile-5-190318152524.jpg",
                    0,
                    10,
                    "50%"
                )
            )
            add(
                InfoFood(
                    "Dimsum Điểm Tâm Đài Loan - Nguyễn Biểu",
                    "https://images.foody.vn/res/g5/42862/prof/s1242x600/foody-upload-api-foody-mobile-3-191106163119.jpg",
                    0,
                    10,
                    "10%"
                )
            )
            add(
                InfoFood(
                    "Kai Coffee - Đường C18",
                    "https://images.foody.vn/res/g102/1011715/prof/s640x400/foody-upload-api-foody-mobile-40-200522171126.jpg",
                    0,
                    10,
                    "100%"
                )
            )
            add(
                InfoFood(
                    "Vườn Xưa - Bánh Cuốn Thịt Nướng",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    10,
                    20,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Trà Sữa Cha Cha",
                    "https://images.foody.vn/res/g4/34536/prof/s1242x600/foody-mobile-3-jpg.jpg",
                    10,
                    10,
                    "30%"
                )
            )
            add(
                InfoFood(
                    "Bếp Văn Chương - Cơm Gà Sốt Cay Hàn Quốc",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    20,
                    10,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Organicfood.vn - Siêu Thị Thực Phẩm Hữu Cơ",
                    "https://images.foody.vn/res/g100/996369/prof/s1242x600/foody-upload-api-foody-mobile-wdwd-200110113827.jpg",
                    10,
                    20,
                    "60%"
                )
            )
            add(
                InfoFood(
                    "Meiwei - Dimsum & Hải Sản Hấp - Láng Hạ",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    0,
                    20,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Botanica Restaurant - Thái Phiên",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    10,
                    20,
                    "20%"
                )
            )
        }))
    }

    fun getListTab() = ArrayList<BaseModel<TabEntity>>().apply {
        add(BaseModel(ArrayList<TabEntity>().apply {
            add(TabEntity(0, R.string.order))
            add(TabEntity(1, R.string.near))
            add(TabEntity(2, R.string.good_price))
        }))
    }

    fun getListOder() = ArrayList<BaseModel<InfoFood>>().apply {
        add(BaseModel(ArrayList<InfoFood>().apply {
            add(
                InfoFood(
                    "Vườn Xưa - Bánh Cuốn Thịt Nướng",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    10,
                    20,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Trà Sữa Cha Cha",
                    "https://images.foody.vn/res/g4/34536/prof/s1242x600/foody-mobile-3-jpg.jpg",
                    10,
                    10,
                    "30%"
                )
            )
            add(
                InfoFood(
                    "Bếp Văn Chương - Cơm Gà Sốt Cay Hàn Quốc",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    20,
                    10,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Organicfood.vn - Siêu Thị Thực Phẩm Hữu Cơ",
                    "https://images.foody.vn/res/g100/996369/prof/s1242x600/foody-upload-api-foody-mobile-wdwd-200110113827.jpg",
                    10,
                    20,
                    "60%"
                )
            )
            add(
                InfoFood(
                    "Meiwei - Dimsum & Hải Sản Hấp - Láng Hạ",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    0,
                    20,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Botanica Restaurant - Thái Phiên",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    10,
                    20,
                    "20%"
                )
            )
            add(
                InfoFood(
                    "Chợ Phố Fresh Food - Trái Cây Nhập Khẩu",
                    "https://images.foody.vn/res/g5/43892/prof/s1242x600/foody-mobile-_cqc9880-jpg-780-636118801575407376.jpg",
                    20,
                    40,
                    "80%"
                )
            )
            add(
                InfoFood(
                    "Cửa Hàng Trái Cây Farm Của Tùng",
                    "https://images.foody.vn/res/g100/996369/prof/s1242x600/foody-upload-api-foody-mobile-wdwd-200110113827.jpg",
                    10,
                    20,
                    "50%"
                )
            )
            add(
                InfoFood(
                    "Kai Coffee - Đường C18",
                    "https://images.foody.vn/res/g79/783117/prof/s1242x600/foody-upload-api-foody-mobile-29-191220093424.jpg",
                    10,
                    20,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Cá Hồi Annaseafresh - Phan Đình Phùng",
                    "https://images.foody.vn/res/g4/36729/prof/s1242x600/foody-upload-api-foody-mobile-3-200515150314.jpg",
                    5,
                    10,
                    "10%"
                )
            )
            add(
                InfoFood(
                    "Đặc Sản Nắng Gió - Thịt, Hải Sản & Khô Các Loại",
                    "https://images.foody.vn/res/g74/735585/prof/s1242x600/foody-upload-api-foody-mobile-5-190318152524.jpg",
                    0,
                    10,
                    "50%"
                )
            )
            add(
                InfoFood(
                    "Dimsum Điểm Tâm Đài Loan - Nguyễn Biểu",
                    "https://images.foody.vn/res/g5/42862/prof/s1242x600/foody-upload-api-foody-mobile-3-191106163119.jpg",
                    0,
                    10,
                    "10%"
                )
            )
            add(
                InfoFood(
                    "Kai Coffee - Đường C18",
                    "https://images.foody.vn/res/g102/1011715/prof/s640x400/foody-upload-api-foody-mobile-40-200522171126.jpg",
                    0,
                    10,
                    "100%"
                )
            )
            add(
                InfoFood(
                    "Kai Coffee - Đường C18",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    10,
                    20,
                    "60%"
                )
            )
            add(
                InfoFood(
                    "BlackBall - Chè & Trà Sữa Đài Loan - Khu Du Lịch Bến Xưa",
                    "https://images.foody.vn/res/g86/855450/prof/s1242x600/foody-upload-api-foody-mobile-119626488-jpg-181130163617.jpg",
                    15,
                    20,
                    "30%"
                )
            )
            add(
                InfoFood(
                    "Oppa Milk Tea",
                    "https://images.foody.vn/res/g30/292890/prof/s1242x600/foody-mobile-foody-d-maris-buffet-301-636142012753318871.jpg",
                    0,
                    10,
                    "20%"
                )
            )
            add(
                InfoFood(
                    "Vườn Xưa - Bánh Cuốn Thịt Nướng",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    10,
                    20,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Trà Sữa Cha Cha",
                    "https://images.foody.vn/res/g4/34536/prof/s1242x600/foody-mobile-3-jpg.jpg",
                    10,
                    10,
                    "30%"
                )
            )
            add(
                InfoFood(
                    "Bếp Văn Chương - Cơm Gà Sốt Cay Hàn Quốc",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    20,
                    10,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Organicfood.vn - Siêu Thị Thực Phẩm Hữu Cơ",
                    "https://images.foody.vn/res/g100/996369/prof/s1242x600/foody-upload-api-foody-mobile-wdwd-200110113827.jpg",
                    10,
                    20,
                    "60%"
                )
            )
            add(
                InfoFood(
                    "Meiwei - Dimsum & Hải Sản Hấp - Láng Hạ",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    0,
                    20,
                    "40%"
                )
            )
        }))
    }

    fun getListNear() = ArrayList<BaseModel<InfoFood>>().apply {
        add(BaseModel(ArrayList<InfoFood>().apply {
            add(
                InfoFood(
                    "Kai Coffee - Đường C18",
                    "https://images.foody.vn/res/g79/783117/prof/s1242x600/foody-upload-api-foody-mobile-29-191220093424.jpg",
                    10,
                    20,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Cá Hồi Annaseafresh - Phan Đình Phùng",
                    "https://images.foody.vn/res/g4/36729/prof/s1242x600/foody-upload-api-foody-mobile-3-200515150314.jpg",
                    5,
                    10,
                    "10%"
                )
            )
            add(
                InfoFood(
                    "Đặc Sản Nắng Gió - Thịt, Hải Sản & Khô Các Loại",
                    "https://images.foody.vn/res/g74/735585/prof/s1242x600/foody-upload-api-foody-mobile-5-190318152524.jpg",
                    0,
                    10,
                    "50%"
                )
            )
            add(
                InfoFood(
                    "Dimsum Điểm Tâm Đài Loan - Nguyễn Biểu",
                    "https://images.foody.vn/res/g5/42862/prof/s1242x600/foody-upload-api-foody-mobile-3-191106163119.jpg",
                    0,
                    10,
                    "10%"
                )
            )
            add(
                InfoFood(
                    "Kai Coffee - Đường C18",
                    "https://images.foody.vn/res/g102/1011715/prof/s640x400/foody-upload-api-foody-mobile-40-200522171126.jpg",
                    0,
                    10,
                    "100%"
                )
            )
            add(
                InfoFood(
                    "Vườn Xưa - Bánh Cuốn Thịt Nướng",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    10,
                    20,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Trà Sữa Cha Cha",
                    "https://images.foody.vn/res/g4/34536/prof/s1242x600/foody-mobile-3-jpg.jpg",
                    10,
                    10,
                    "30%"
                )
            )
            add(
                InfoFood(
                    "Bếp Văn Chương - Cơm Gà Sốt Cay Hàn Quốc",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    20,
                    10,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Organicfood.vn - Siêu Thị Thực Phẩm Hữu Cơ",
                    "https://images.foody.vn/res/g100/996369/prof/s1242x600/foody-upload-api-foody-mobile-wdwd-200110113827.jpg",
                    10,
                    20,
                    "60%"
                )
            )
            add(
                InfoFood(
                    "Meiwei - Dimsum & Hải Sản Hấp - Láng Hạ",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    0,
                    20,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Botanica Restaurant - Thái Phiên",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    10,
                    20,
                    "20%"
                )
            )
            add(
                InfoFood(
                    "Chợ Phố Fresh Food - Trái Cây Nhập Khẩu",
                    "https://images.foody.vn/res/g5/43892/prof/s1242x600/foody-mobile-_cqc9880-jpg-780-636118801575407376.jpg",
                    20,
                    40,
                    "80%"
                )
            )
            add(
                InfoFood(
                    "Cửa Hàng Trái Cây Farm Của Tùng",
                    "https://images.foody.vn/res/g100/996369/prof/s1242x600/foody-upload-api-foody-mobile-wdwd-200110113827.jpg",
                    10,
                    20,
                    "50%"
                )
            )
            add(
                InfoFood(
                    "Kai Coffee - Đường C18",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    10,
                    20,
                    "60%"
                )
            )
            add(
                InfoFood(
                    "BlackBall - Chè & Trà Sữa Đài Loan - Khu Du Lịch Bến Xưa",
                    "https://images.foody.vn/res/g86/855450/prof/s1242x600/foody-upload-api-foody-mobile-119626488-jpg-181130163617.jpg",
                    15,
                    20,
                    "30%"
                )
            )
            add(
                InfoFood(
                    "Oppa Milk Tea",
                    "https://images.foody.vn/res/g30/292890/prof/s1242x600/foody-mobile-foody-d-maris-buffet-301-636142012753318871.jpg",
                    0,
                    10,
                    "20%"
                )
            )
            add(
                InfoFood(
                    "Vườn Xưa - Bánh Cuốn Thịt Nướng",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    10,
                    20,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Trà Sữa Cha Cha",
                    "https://images.foody.vn/res/g4/34536/prof/s1242x600/foody-mobile-3-jpg.jpg",
                    10,
                    10,
                    "30%"
                )
            )
            add(
                InfoFood(
                    "Bếp Văn Chương - Cơm Gà Sốt Cay Hàn Quốc",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    20,
                    10,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Organicfood.vn - Siêu Thị Thực Phẩm Hữu Cơ",
                    "https://images.foody.vn/res/g100/996369/prof/s1242x600/foody-upload-api-foody-mobile-wdwd-200110113827.jpg",
                    10,
                    20,
                    "60%"
                )
            )
            add(
                InfoFood(
                    "Meiwei - Dimsum & Hải Sản Hấp - Láng Hạ",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    0,
                    20,
                    "40%"
                )
            )
        }))
    }

    fun getListGoodPrice() = ArrayList<BaseModel<InfoFood>>().apply {
        add(BaseModel(ArrayList<InfoFood>().apply {
            add(
                InfoFood(
                    "Kai Coffee - Đường C18",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    10,
                    20,
                    "60%"
                )
            )
            add(
                InfoFood(
                    "BlackBall - Chè & Trà Sữa Đài Loan - Khu Du Lịch Bến Xưa",
                    "https://images.foody.vn/res/g86/855450/prof/s1242x600/foody-upload-api-foody-mobile-119626488-jpg-181130163617.jpg",
                    15,
                    20,
                    "30%"
                )
            )
            add(
                InfoFood(
                    "Oppa Milk Tea",
                    "https://images.foody.vn/res/g30/292890/prof/s1242x600/foody-mobile-foody-d-maris-buffet-301-636142012753318871.jpg",
                    0,
                    10,
                    "20%"
                )
            )
            add(
                InfoFood(
                    "Vườn Xưa - Bánh Cuốn Thịt Nướng",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    10,
                    20,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Trà Sữa Cha Cha",
                    "https://images.foody.vn/res/g4/34536/prof/s1242x600/foody-mobile-3-jpg.jpg",
                    10,
                    10,
                    "30%"
                )
            )
            add(
                InfoFood(
                    "Bếp Văn Chương - Cơm Gà Sốt Cay Hàn Quốc",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    20,
                    10,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Organicfood.vn - Siêu Thị Thực Phẩm Hữu Cơ",
                    "https://images.foody.vn/res/g100/996369/prof/s1242x600/foody-upload-api-foody-mobile-wdwd-200110113827.jpg",
                    10,
                    20,
                    "60%"
                )
            )
            add(
                InfoFood(
                    "Meiwei - Dimsum & Hải Sản Hấp - Láng Hạ",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    0,
                    20,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Kai Coffee - Đường C18",
                    "https://images.foody.vn/res/g79/783117/prof/s1242x600/foody-upload-api-foody-mobile-29-191220093424.jpg",
                    10,
                    20,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Cá Hồi Annaseafresh - Phan Đình Phùng",
                    "https://images.foody.vn/res/g4/36729/prof/s1242x600/foody-upload-api-foody-mobile-3-200515150314.jpg",
                    5,
                    10,
                    "10%"
                )
            )
            add(
                InfoFood(
                    "Đặc Sản Nắng Gió - Thịt, Hải Sản & Khô Các Loại",
                    "https://images.foody.vn/res/g74/735585/prof/s1242x600/foody-upload-api-foody-mobile-5-190318152524.jpg",
                    0,
                    10,
                    "50%"
                )
            )
            add(
                InfoFood(
                    "Dimsum Điểm Tâm Đài Loan - Nguyễn Biểu",
                    "https://images.foody.vn/res/g5/42862/prof/s1242x600/foody-upload-api-foody-mobile-3-191106163119.jpg",
                    0,
                    10,
                    "10%"
                )
            )
            add(
                InfoFood(
                    "Kai Coffee - Đường C18",
                    "https://images.foody.vn/res/g102/1011715/prof/s640x400/foody-upload-api-foody-mobile-40-200522171126.jpg",
                    0,
                    10,
                    "100%"
                )
            )
            add(
                InfoFood(
                    "Vườn Xưa - Bánh Cuốn Thịt Nướng",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    10,
                    20,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Trà Sữa Cha Cha",
                    "https://images.foody.vn/res/g4/34536/prof/s1242x600/foody-mobile-3-jpg.jpg",
                    10,
                    10,
                    "30%"
                )
            )
            add(
                InfoFood(
                    "Bếp Văn Chương - Cơm Gà Sốt Cay Hàn Quốc",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    20,
                    10,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Organicfood.vn - Siêu Thị Thực Phẩm Hữu Cơ",
                    "https://images.foody.vn/res/g100/996369/prof/s1242x600/foody-upload-api-foody-mobile-wdwd-200110113827.jpg",
                    10,
                    20,
                    "60%"
                )
            )
            add(
                InfoFood(
                    "Meiwei - Dimsum & Hải Sản Hấp - Láng Hạ",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    0,
                    20,
                    "40%"
                )
            )
            add(
                InfoFood(
                    "Botanica Restaurant - Thái Phiên",
                    "https://images.foody.vn/res/g95/941618/prof/s1242x600/foody-upload-api-foody-mobile-3-200305100616.jpg",
                    10,
                    20,
                    "20%"
                )
            )
            add(
                InfoFood(
                    "Chợ Phố Fresh Food - Trái Cây Nhập Khẩu",
                    "https://images.foody.vn/res/g5/43892/prof/s1242x600/foody-mobile-_cqc9880-jpg-780-636118801575407376.jpg",
                    20,
                    40,
                    "80%"
                )
            )
            add(
                InfoFood(
                    "Cửa Hàng Trái Cây Farm Của Tùng",
                    "https://images.foody.vn/res/g100/996369/prof/s1242x600/foody-upload-api-foody-mobile-wdwd-200110113827.jpg",
                    10,
                    20,
                    "50%"
                )
            )
        }))
    }
}