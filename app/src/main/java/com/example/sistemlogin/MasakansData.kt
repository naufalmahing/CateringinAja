package com.example.sistemlogin

object MasakansData {
    private var namaMasakan = arrayOf("Nasi Goreng",
        "Paket Idul Fitri",
        "Paket Bakso Lengkap",
        "Nasi Pecel"
    )

    private var hargaMasakan = arrayOf("20000", "100000", "15000","10000")

//    private var fotoMasakan = intArrayOf(R.drawable.masakan_1,
//        R.drawable.masakan_2,
//        R.drawable.masakan_3,
//        R.drawable.masakan_4
//    )

    private var deskripsi = arrayOf("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book"
    )

    val listData: ArrayList<Masakan>
        get() {
            val listMasakan = arrayListOf<Masakan>()

            for(position in namaMasakan.indices) {
                val masakan = Masakan(namaMasakan[position], deskripsi[position], hargaMasakan[position].toInt())
//                masakan.nama = namaMasakan[position]
//                masakan.harga = hargaMasakan[position]
//                masakan.photo = fotoMasakan[position]
//                masakan.deskripsi = deskripsi[position]
                listMasakan.add(masakan)
            }
            return listMasakan
        }
}