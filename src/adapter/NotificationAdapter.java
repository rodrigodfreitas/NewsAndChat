package adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class NotificationAdapter extends BaseAdapter {

	private ArrayList<?> notifica;
	private int R_layout_IdView;
	private Context contexto;

	public NotificationAdapter(ArrayList<?> notifica, int r_layout_IdView,
			Context contexto) {
		super();
		this.notifica = notifica;
		R_layout_IdView = r_layout_IdView;
		this.contexto = contexto;
	}

	@Override
	public View getView(int posicao, View view, ViewGroup pariente) {
		if (view == null) {
			LayoutInflater vi = (LayoutInflater) contexto
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = vi.inflate(R_layout_IdView, null);
		}
		onNotificacao(notifica.get(posicao), view);
		return view;
	}

	@Override
	public int getCount() {
		return notifica.size();
	}

	@Override
	public Object getItem(int posicao) {
		return notifica.get(posicao);
	}

	@Override
	public long getItemId(int posicao) {
		return posicao;
	}

	public abstract void onNotificacao(Object nota, View view);

}
