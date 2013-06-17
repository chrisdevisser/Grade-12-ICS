#include <windows.h>
#include <sapi.h>

extern "C" __declspec(dllexport) int Speak(LPCWSTR text) {
	ISpVoice *v;

	if (FAILED(CoInitialize(nullptr))) {
		return 1;
	}

	HRESULT hr = CoCreateInstance(CLSID_SpVoice, nullptr, CLSCTX_ALL, IID_ISpVoice, (void**)&v);
	if (FAILED(hr)) {
		return 2;
	}

	v->Speak(text, 0, nullptr);
	v->Release();

	CoUninitialize();
	return 0;
}
