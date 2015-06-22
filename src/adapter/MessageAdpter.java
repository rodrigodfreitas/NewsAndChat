package adapter;

import java.util.List;

import beans.Message;
import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MessageAdpter extends BaseAdapter {
	
	private Context context;
	private List<Message> lista;
	
	

	public MessageAdpter(Context context, List<Message> lista) {
		super();
		this.context = context;
		this.lista = lista;
	}

	@Override
	public int getCount() {
		return lista.size();
	}

	@Override
	public Object getItem(int position) {
		return lista.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
//		//Message message = lista.get(position);
//		
//		//int arquivoLayout = R.layout.noticia_completa;
//		
//		View rowView = convertView;
//		
//		if(convertView == null) {
//			LayoutInflater inflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//			rowView = inflater.inflate(R.layout)
//		}
//		
//		
		
		return null;
	}

}
