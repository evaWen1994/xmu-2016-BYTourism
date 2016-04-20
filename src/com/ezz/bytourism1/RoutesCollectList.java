package com.ezz.bytourism1;

/**
 * Created by 37492 on 2016/4/7.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.ezz.bean.Collect;
import com.ezz.bean.Scenic;
import com.ezz.bean.Scenicroute;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

public class RoutesCollectList extends BaseActivity implements OnItemClickListener,OnScrollListener{
    private ListView listView;
    private ArrayAdapter< String> arr_adapter;
    private SimpleAdapter simp_adapter;
    private Integer userid;
    private List<Map<String, Object>> dataList;
    private String[] arr_data = {""};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO �Զ����ɵķ������
        super.onCreate(savedInstanceState);
        setContentView(R.layout.routescollect);

        //��������
        userid = getPreferenceId();
        BmobQuery<Collect> query_city = new BmobQuery<Collect>();
        query_city.addWhereEqualTo("userid", userid);
        query_city.addWhereEqualTo("type", 2);
        //��ȡ�û�����·��
        query_city.findObjects(RoutesCollectList.this, new FindListener<Collect>() {
            @Override
            public void onSuccess(List<Collect> collects) {
                int i=0;
                final String[] route = {""};
                // TODO �Զ����ɵķ������
                for(Collect collect:collects){
                    //��ÿһ��·�߻�ȡ��Ӧ�ĵص�
                    int id = collect.getCid();
                    BmobQuery<Scenicroute> scenicroute_query = new BmobQuery<Scenicroute>();
                    scenicroute_query.addWhereEqualTo("id", id);
                    scenicroute_query.findObjects(RoutesCollectList.this, new FindListener<Scenicroute>() {
                        @Override
                        public void onError(int arg0, String arg1) {
                            // TODO �Զ����ɵķ������
                            Log.i("fail---70", arg0 + arg1);
                        }

                        @Override
                        public void onSuccess(List<Scenicroute> scenicroutes) {
                            //·����Ϣ

                            // TODO �Զ����ɵķ������
                            if (scenicroutes.get(0).getOne() != 0) {
                                BmobQuery<Scenic> query_scenic = new BmobQuery<Scenic>();
                                query_scenic.addWhereEqualTo("id", scenicroutes.get(0).getOne());
                                query_scenic.findObjects(RoutesCollectList.this, new FindListener<Scenic>() {
                                    @Override
                                    public void onError(int arg0, String arg1) {
                                        // TODO �Զ����ɵķ������
                                        Log.i("fail---70", arg0 + arg1);
                                    }

                                    @Override
                                    public void onSuccess(List<Scenic> scenics) {
                                        // TODO �Զ����ɵķ������
                                        Message msg = new Message();

                                        route[0] = scenics.get(0).getScenicname();

                                    }
                                });
                            }
                            if (scenicroutes.get(0).getTwo() != 0) {
                                BmobQuery<Scenic> query_scenic = new BmobQuery<Scenic>();
                                query_scenic.addWhereEqualTo("id", scenicroutes.get(0).getTwo());
                                query_scenic.findObjects(RoutesCollectList.this, new FindListener<Scenic>() {
                                    @Override
                                    public void onError(int arg0, String arg1) {
                                        // TODO �Զ����ɵķ������
                                        Log.i("fail---70", arg0 + arg1);
                                    }

                                    @Override
                                    public void onSuccess(List<Scenic> scenics) {
                                        // TODO �Զ����ɵķ������

                                        route[1] = scenics.get(0).getScenicname();
                                    }
                                });
                            }
                            if (scenicroutes.get(0).getThree() != 0) {
                                BmobQuery<Scenic> query_scenic = new BmobQuery<Scenic>();
                                query_scenic.addWhereEqualTo("id", scenicroutes.get(0).getThree());
                                query_scenic.findObjects(RoutesCollectList.this, new FindListener<Scenic>() {
                                    @Override
                                    public void onError(int arg0, String arg1) {
                                        // TODO �Զ����ɵķ������
                                        Log.i("fail---70", arg0 + arg1);
                                    }

                                    @Override
                                    public void onSuccess(List<Scenic> scenics) {
                                        // TODO �Զ����ɵķ������
                                        route[2] = scenics.get(0).getScenicname();
                                    }
                                });
                            }
                            if (scenicroutes.get(0).getFour() != 0) {
                                BmobQuery<Scenic> query_scenic = new BmobQuery<Scenic>();
                                query_scenic.addWhereEqualTo("id", scenicroutes.get(0).getFour());
                                query_scenic.findObjects(RoutesCollectList.this, new FindListener<Scenic>() {
                                    @Override
                                    public void onError(int arg0, String arg1) {
                                        // TODO �Զ����ɵķ������
                                        Log.i("fail---70", arg0 + arg1);
                                    }

                                    @Override
                                    public void onSuccess(List<Scenic> scenics) {
                                        // TODO �Զ����ɵķ������
                                        route[3] = scenics.get(0).getScenicname();
                                    }
                                });
                            }
                            if (scenicroutes.get(0).getFive() != 0) {
                                BmobQuery<Scenic> query_scenic = new BmobQuery<Scenic>();
                                query_scenic.addWhereEqualTo("id", scenicroutes.get(0).getFive());
                                query_scenic.findObjects(RoutesCollectList.this, new FindListener<Scenic>() {
                                    @Override
                                    public void onError(int arg0, String arg1) {
                                        // TODO �Զ����ɵķ������
                                        Log.i("fail---70", arg0 + arg1);
                                    }

                                    @Override
                                    public void onSuccess(List<Scenic> scenics) {
                                        // TODO �Զ����ɵķ������
                                        route[4] = scenics.get(0).getScenicname();
                                    }
                                });
                            }
                        }

                    });

                    arr_data[i] = route[0]+"-"+route[1]+"-"+route[2]+"-"+route[3]+"-"+route[4];
                    i++;
                    //��·����Ϣ�ÿ�
                    for (int j=0;j<5;j++){
                        route[j]=null;
                    }
                }
            }
            @Override
            public void onError(int arg0, String arg1) {
                // TODO �Զ����ɵķ������
                Log.i("fail!!---60", arg0+arg1);
            }
        });

        //end
        listView = (ListView)findViewById(R.id.routeslist);
        //1.����һ������������
        //ArrayAdapter(�����ģ���ǰListView����ÿһ���б�������Ӧ�Ĳ����ļ�������Դ)
        //2.��������������Դ
        //3.��ͼ��ListView������������
		/*SimpleAdapter
		 * 1.����һ��������
		 * 2.��������������Դ
		 * 3.��ͼ(ListView)����������
		 * listView.setAapter(arr_adapter)
		 * */

        dataList = new ArrayList<Map<String,Object>>();
        arr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr_data);
        //	listView.setAdapter(arr_adapter);

        /**
         * SimpleAdapter:
         * context��������
         * data������Դ(List< ?extends Map<String,?>>data)һ��Map����ɵ�List����
         * 			  ÿһ��Map����ȥ��ӦListView�б��һ��
         * 			 ÿһ��Map<��-ֵ��>�еļ������������from��ָ���ļ�
         * resource���б���Ĳ����ļ�ID
         * from��Map�еļ���
         * to��������Դ��ͼ��ID����from�ɶ�Ӧ��ϵ
         * */
        simp_adapter = new SimpleAdapter(this, getData(), R.layout.routescollect_item,new String[]{"pic","text"} ,new int[]{R.id.image,R.id.title});

        listView.setAdapter(simp_adapter);
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);
    }
    private List<Map<String, Object>> getData(){
        for(int i = 0;i<5;i++){
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("pic", R.drawable.ic_launcher);
            map.put("text", arr_data[i]);
            dataList.add(map);

        }
        return dataList;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        // TODO �Զ����ɵķ������
        String text = listView.getItemAtPosition(position)+"";
        Toast.makeText(this, "position="+position +"text = "+text, Toast.LENGTH_LONG).show();

    }
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        // TODO �Զ����ɵķ������
        switch (scrollState) {
            case SCROLL_STATE_FLING:
                Map<String, Object> map = new HashMap<String,Object>();
                map.put("pic", R.drawable.ic_launcher);
                map.put("text", "������");
                dataList.add(map);
                simp_adapter.notifyDataSetChanged();
                break;
            case SCROLL_STATE_IDLE:
                break;
            case SCROLL_STATE_TOUCH_SCROLL:
                break;
            default:
                break;
        }
    }
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        // TODO �Զ����ɵķ������

    }
}