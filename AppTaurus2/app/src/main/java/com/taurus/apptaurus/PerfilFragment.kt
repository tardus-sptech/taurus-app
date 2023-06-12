package com.taurus.apptaurus

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.taurus.apptaurus.external.Apis
import com.taurus.apptaurus.response.UsuarioDados
import com.taurus.apptaurus.util.UserManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PerfilFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PerfilFragment : Fragment() {
    // TODO: Rename and change types of parameters
    val nomeUser = UserManager.userNome
    val idUser = UserManager.userId
    val apiUsuario = Apis.getApiUsuarios().getDados(idUser)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_perfil  , container, false)
        val nomePerfil = view.findViewById<TextView>(R.id.nomePerfil)

        var exitButton = view.findViewById<TextView>(R.id.sair)
        exitButton.setOnClickListener {
            it.animate()
                .scaleX(0.9f)
                .scaleY(0.9f)
                .setDuration(100)
                .withEndAction {
                    it.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(100)
                        .start()
                }
                .start()
            val intent = Intent(requireContext(), TelaIntro1::class.java)
            startActivity(intent)
        }

        apiUsuario.enqueue(object : Callback<UsuarioDados> {
            override fun onResponse(call: Call<UsuarioDados>, response: Response<UsuarioDados>) {
                if (response.isSuccessful) {
                    if (response.body()?.id != null) {
                        nomePerfil.text = nomeUser
                    }
                }
            }

            override fun onFailure(call: Call<UsuarioDados>, t: Throwable) {
                nomePerfil.text = "Erro no valor"
                println(t.printStackTrace())
            }

        })


        return view
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PerfilFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}