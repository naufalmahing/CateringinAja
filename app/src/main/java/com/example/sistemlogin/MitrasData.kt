package com.example.sistemlogin

object MitrasData {
    private val namaMitra = arrayOf("Ariih Catering",
        "Eiffel Tower",
        "Abbasy Catering",
        "Afdhol Catering",
        "Basyarah Catering",
        "Barokah Catering",

    )

    private var lokasiMitra = arrayOf("Surabaya",
        "Malang",
        "Blitar",
        "Kediri",
        "Madiun",
        "Probolinggo"
    )

    private val deskripsiMitra = arrayOf("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book",
    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book",
    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book",
    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book",
    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book")

//    private var photoMitra = intArrayOf(R.drawable.gambar_1,
//        R.drawable.gambar_2,
//        R.drawable.gambar_3,
//        R.drawable.gambar_4,
//        R.drawable.gambar_5,
//        R.drawable.gambar_6,
//    )


    val listData: ArrayList<Mitra>
        get() {
            val listMitra = arrayListOf<Mitra>()

            for(position in namaMitra.indices) {
                val mitra = Mitra(namaMitra[position], "12345", namaMitra[position], "", deskripsiMitra[position], lokasiMitra[position], "")
//                mitra.name = namaMitra[position]
//                mitra.location = lokasiMitra[position]
//                mitra.description = deskripsiMitra[position]
//                mitra.photo = photoMitra[position]
                listMitra.add(mitra)
            }
            return listMitra
        }
}