package org.zkforge.resort.ui;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Textbox;
import org.zkoss.gmaps.Gmaps;
import org.zkoss.gmaps.Ginfo;

import foo.Resort;

public class ResortController extends GenericForwardComposer<Component> {

	private static final long serialVersionUID = 1L;

	private Textbox name;
	private Textbox desc;
	private Doublebox latitude;
	private Doublebox longitude;
	private Listbox lb;
	private Gmaps gmap;
	private Ginfo ginfo;
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		lb.setItemRenderer(new ListitemRenderer<Resort>() {

			public void render(Listitem item, Resort obj, int arg2)
					throws Exception {
				item.appendChild(new Listcell(obj.getName()));
				item.appendChild(new Listcell(obj.getDescription()));
				item.setValue(obj);
			}
		});
		lb.setModel(new ListModelList<Resort>(Resort.getAll()));
	}
	
	public void onSelect$lb() {
		refreshUI();
	}
	
	private void refreshUI() {
		Resort resort = lb.getSelectedItem().getValue();
		double latitudeValue = resort.getLatitude();
		double longtitudeValue = resort.getLongitude();
		
		name.setValue(resort.getName());
		desc.setValue(resort.getDescription());
		latitude.setValue(latitudeValue);
		longitude.setValue(longtitudeValue);
		ginfo.setLat(latitudeValue);
		ginfo.setLng(longtitudeValue);
		ginfo.setContent(resort.getDescription());
		gmap.panTo(latitudeValue, longtitudeValue);
		gmap.setZoom(16);
		gmap.openInfo(ginfo);
	}
}
	