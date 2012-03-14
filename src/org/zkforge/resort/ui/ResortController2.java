package org.zkforge.resort.ui;

import java.util.List;

import org.zkoss.gmaps.Ginfo;
import org.zkoss.gmaps.Gmaps;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;

import foo.Resort;

public class ResortController2 extends GenericForwardComposer<Component> {

	private static final long serialVersionUID = 1L;

	private Gmaps gmap;
	private Ginfo ginfo;
	private Resort _selected;
	private List<Resort> _resorts;
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		setResorts(Resort.getAll());
		_selected = new Resort();
	}
	
	public void onSelect$lb() {
		refreshUI();
	}
	
	private void refreshUI() {
		double latitudeValue = _selected.getLatitude();
		double longtitudeValue = _selected.getLongitude();
		ginfo.setLat(latitudeValue);
		ginfo.setLng(longtitudeValue);
		ginfo.setContent(_selected.getDescription());
		gmap.panTo(latitudeValue, longtitudeValue);
		gmap.setZoom(16);
		gmap.openInfo(ginfo);
	}
	
	public Resort getSelected() {
		return _selected;
	}
	
	public void setSelected(Resort selected) {
		_selected = selected;
	}
	
	public void setResorts(List<Resort> _resorts) {
        this._resorts = _resorts;
    }
 
    public List<Resort> getResorts() {
        return _resorts;
    }
}
	